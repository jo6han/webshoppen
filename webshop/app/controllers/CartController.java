package controllers;

import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import model.Product;
import model.ShoppingCart;
import model.User;
import play.*;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.*;

@Transactional
public class CartController extends Controller {
	

	public static Result getAllProductsFromCart(){
		if(session().size() <= 0){
			flash().put("no-user", "yes");
			return redirect(routes.Application.index());
		}
		return ok(shoppingCart.render(getCart()));
	}
	

	public static Result updateCart(){
		if(session().size() <= 0){
			flash().put("no-user", "yes");
			return redirect(routes.Application.index());
		}
		return ok(updateShoppingCart.render(getCart()));
	}
	
	public static Result addingToCart(){
//		Can add @Security.Authenticated, but added function to notify the user
//		if the user is not logged in, by using flash().put
		Map<String, String[]> form = request().body().asFormUrlEncoded();
		
		Integer quantity = Integer.parseInt(form.get("quantity")[0]);
		Integer prodInteger = Integer.parseInt(form.get("prod-id")[0]);
		Product prod = getProd(prodInteger);
		
		if(session().size() == 0){
			flash().put("no-user-found", "yes");
			return redirect(routes.ProductController.getOneProduct(prod.id));
		}
		
		User currentUser = getUser();
		ShoppingCart cartProd = getCartProd(prod, quantity, currentUser);
		
		if(checkIfProdAlreadyExistInCart(prod)){
			flash().put("already-exists-in-cart", "yes");
			return redirect(routes.ProductController.getOneProduct(prod.id));
		}
		
		if(prod.quantity >= quantity){
			
			JPA.em().persist(cartProd);
			JPA.em().persist(currentUser);

			return redirect(routes.CartController.getAllProductsFromCart());
		}
		
		if(prod.quantity < quantity){
			flash().put("too-much", "yes");
			
			return redirect(routes.ProductController.getOneProduct(prod.id));
		}
		
		return ok("FATAL ERROR DO SOMEThING");
		
	}
	
	public static Result updatingCart(){
		if(session().size() == 0){
			flash().put("no-user-found", "yes");
			return redirect(routes.Application.index());
		}
		
		Map<String, String[]> form = request().body().asFormUrlEncoded();
		Integer quantity = Integer.parseInt(form.get("quantity")[0]);
		Integer cartProdInteger = Integer.parseInt(form.get("cartProd-id")[0]);
		User currentUser = getUser();
		List<ShoppingCart> tmpCart = getCart();
		ShoppingCart tmpCartProd = JPA.em().find(ShoppingCart.class, cartProdInteger);
		Product prod = getProdUsingName(tmpCartProd.name);
		
		if(prod.quantity < quantity){
			flash().put("too-much", "yes");
			return redirect(routes.CartController.updateCart());
		}		
		
		
		tmpCartProd.quantity = quantity;
		currentUser.cartList = tmpCart;
		
		JPA.em().merge(currentUser);
		JPA.em().merge(tmpCartProd);

		
		
		return ok(shoppingCart.render(getCart()));
	}
	
	private static boolean checkIfProdAlreadyExistInCart(Product prod) {
		boolean doesExist = false;
		List<ShoppingCart> cart = getCart();
		for (ShoppingCart shoppingCart : cart) {
			if(shoppingCart.name.equals(prod.name) || shoppingCart.cost == prod.cost){
				doesExist = true;
			}
		}
		return doesExist;
	}

	private static ShoppingCart getCartProd(Product prod, int quantity, User user) {
		ShoppingCart tmpCartProd = new ShoppingCart();
		
		tmpCartProd.name = prod.name;
		tmpCartProd.description = prod.description;
		tmpCartProd.cost = prod.cost;
		tmpCartProd.rrp = prod.rrp;
		tmpCartProd.quantity = quantity;
		tmpCartProd.userList.add(user);
		return tmpCartProd;
	}

	private static User getUser(){
		User currentUser = JPA.em().find(User.class, Integer.parseInt(session().get("id")));
		return currentUser;
	}
	
	private static Product getProd(int prodInteger){
		Product Prod = JPA.em().find(Product.class, prodInteger);
		return Prod;
	}

	private static Product getProdUsingName(String name){
		
		TypedQuery<Product> query = JPA.em().createQuery("SELECT c FROM Product c WHERE c.name = :prodName", Product.class);
		Product prod = query.setParameter("prodName", name).getSingleResult();
		
		return prod;
		
	}

	private static List<ShoppingCart> getCart(){
		User tmpUser = getUser();
		return tmpUser.cartList;
		
	}
}

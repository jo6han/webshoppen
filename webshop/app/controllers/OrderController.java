package controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.hibernate.annotations.Check;
import org.hibernate.ejb.criteria.expression.function.CurrentDateFunction;

import model.Category;
import model.CheckOut;
import model.Product;
import model.ShoppingCart;
import model.User;
import play.*;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.*;
import scala.Array;
import views.html.*;

@Transactional
public class OrderController extends Controller {
	
	public static Result getAllYourOrders(){
		if(session().size() <= 0){
			flash().put("no-user", "yes");
			return redirect(routes.Application.index());
		}
		User currentUser = getUser();
		return ok(checkOut.render(currentUser.orderUserList));
	}
	
	public static Result addingToOrderFromCart(){
		User currentUser = getUser();
		DateFormat dateFormat = new SimpleDateFormat("yyMMdd");
	    java.util.Date date = new java.util.Date();
		
		for (ShoppingCart cartProd : currentUser.cartList) {
			
			Product prod = getProdUsingName(cartProd.name);	
			
			//Check here quantity for prods and shoppingcart.
			if(prod.quantity < cartProd.quantity){
				flash().put("quantity-too-much", "yes");
				flash().put("prod-name", prod.name);
				return redirect(routes.CartController.getAllProductsFromCart());
			}
			
			CheckOut checkout = new CheckOut();
			checkout.prod_id = prod.id;
			checkout.user_id = currentUser.id;
			checkout.quantity = cartProd.quantity;
			checkout.order_date = Integer.parseInt(dateFormat.format(date));
			checkout.userOrderList.add(currentUser);
			cartProd.userList.remove(currentUser);
			
			//Fix products amount
			int newQuantity = prod.quantity - cartProd.quantity;
			prod.quantity = newQuantity;
			JPA.em().persist(checkout);
			JPA.em().persist(prod);
			JPA.em().remove(cartProd);
		}
		
		currentUser.cartList.clear();
		JPA.em().persist(currentUser);
		
		
		
		
		return redirect(routes.OrderController.getAllYourOrders());
		
	}
	
	private static User getUser(){
		User currentUser = JPA.em().find(User.class, Integer.parseInt(session().get("id")));
		return currentUser;
	}
	
	private static Product getProdUsingName(String name){
		
		TypedQuery<Product> query = JPA.em().createQuery("SELECT c FROM Product c WHERE c.name = :prodName", Product.class);
		Product prod = query.setParameter("prodName", name).getSingleResult();
		
		return prod;
		
	}

}

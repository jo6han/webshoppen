package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Category;
import model.Product;
import play.*;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.*;

@Transactional
public class ProductController extends Controller {
    
	public static Result createNewProduct(){
		Map<String, String[]> form = request().body().asFormUrlEncoded();
		
		String name = form.get("name")[0];
		String desc = form.get("desc")[0];
		Integer cost = Integer.parseInt(form.get("cost")[0]);
		Integer rrp = Integer.parseInt(form.get("rrp")[0]);
		Integer quantity = Integer.parseInt(form.get("quantity")[0]);
		
		//Check here if prod already exists.
		if(checkIfProdExist(name, cost)){
			flash().put("already-exists", "yes");
			return redirect(routes.ProductController.getAllProducts());
		}

		Product product = new Product();
		product.name = name;
		product.description = desc;
		product.cost = cost;
		product.rrp = rrp;
		product.quantity = quantity;
		try{
		for(int i=0; i< form.get("category-id").length ;i++){
				Integer cat = Integer.parseInt(form.get("category-id")[i]);
				Category category = JPA.em().find(Category.class, cat);
				product.catList.add(category);
			}
		}catch(NullPointerException e){
			flash().put("no-cats", "yes");
		}
		JPA.em().persist(product);
		
		return redirect(routes.ProductController.getOneProduct(product.getId()));
	}
	
	@Security.Authenticated
	public static Result creatingProduct(){
		List<Category> cat = JPA.em().createQuery("SELECT a from Category AS a", Category.class).getResultList();

		return ok(createProduct.render(cat));
	}
	
	public static Result getAllProducts(){
		List<model.Product> products = JPA.em().createQuery("SELECT a FROM Product a", Product.class).getResultList();
		
		return ok(allProducts.render(products));
	}
	
	public static Result getOneProduct(int id){
		Product prod = JPA.em().find(Product.class, id);
		return ok(theProduct.render(prod));
		
	}
	
	private static boolean checkIfProdExist(String name, Integer cost){
		List<model.Product> products = JPA.em().createQuery("SELECT a FROM Product a", Product.class).getResultList();
		
		for (Product product : products) {
			if(product.getName().equals(name) && product.getCost() == cost){
				return true;
			}
		}
		
		return false;
	}

}

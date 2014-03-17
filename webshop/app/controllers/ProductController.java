package controllers;

import java.util.ArrayList;
import java.util.List;

import com.avaje.ebean.Ebean;

import model.Product;
import play.*;
import play.mvc.*;
import views.html.*;

public class ProductController extends Controller {
    
	public static Result createObjects(){
		
    	Product prod = new Product(3, "Maserati", 321);
    	
    	Ebean.save(prod);

		return ok("Fake objects created.");
	}
	
	public static Result getAllProducts(){
		List<model.Product> products = Ebean.find(Product.class).findList();
		
		return ok(allProducts.render(products));
	}
	
	public static Result getOneProduct(int id){
		Product prod = Ebean.find(Product.class, id);
		return ok(theProduct.render(prod));
		
	}
	
//    public static Result getOneProduct(int id){
//    	Product prod = null;
//    	Product prod1 = new Product(1, "VOLVO", 12);
//    	Product prod2 = new Product(2, "Audi", 12);
//    	if (id == prod1.getProductId()){
//    		prod = prod1;
//    	}
//    	if (id == prod2.getProductId()){
//    		prod = prod2;
//    	}
//    	
//    	return ok(theProduct.render(prod));
//    }
//    
//    public static Result getAllProducts(){
//    	Product prod = new Product(1, "VOLVO", 12);
//    	Product prod2 = new Product(2, "Audi", 12);
//    	List<Product> prodList = new ArrayList<Product>();
//    	prodList.add(prod);
//    	prodList.add(prod2);
//    	return ok(allProducts.render(prodList));
//    }
    
    
    
    

}

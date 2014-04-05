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
public class CategoryController extends Controller {
    
	public static Result createNewCategory(){
		Map<String, String[]> form = request().body().asFormUrlEncoded();
		
		String name = form.get("name")[0];
		int staff_id = Integer.parseInt(form.get("staff-id")[0]);
		
		Category category = new Category();
		category.name = name;
		category.staff_id = staff_id;
		try{
		for(int i=0; i< form.get("product-id").length ;i++){
		Integer prod = Integer.parseInt(form.get("product-id")[i]);
		Product product = JPA.em().find(Product.class, prod);
		category.prodList.add(product);
		product.catList.add(category);
		JPA.em().persist(product);
		}
		}catch(NullPointerException e){
			flash().put("no-prods", "yes");
		}
		
		JPA.em().persist(category);
		
		return redirect(routes.CategoryController.getOneCategory(category.getId()));
	}
	
	@Security.Authenticated
	public static Result creatingCategory(){
		List<Product> prod = JPA.em().createQuery("SELECT a from Product AS a", Product.class).getResultList();

		return ok(createCategory.render(prod));
	}
	
	public static Result getAllCategories(){
		List<model.Category> categories = JPA.em().createQuery("SELECT a FROM Category a", Category.class).getResultList();
		
		return ok(allCategories.render(categories));
	}
	
	public static Result getOneCategory(int id){
		Category cat = JPA.em().find(Category.class, id);
		return ok(theCategory.render(cat));
		
	}
	
}

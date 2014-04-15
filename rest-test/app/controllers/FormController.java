package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import akka.io.Tcp.Bind;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;

import models.Product;
import play.*;
import play.data.Form;
import play.data.validation.ValidationError;
import play.mvc.*;
import views.html.*;
import views.html.helper.form;

public class FormController extends Controller {

	public static Result index() {
		return ok(index.render("Productz"));
	}

	public static Result createNewProduct(){
		Form<Product> form = Form.form(Product.class).bindFromRequest();
    	
		if(form.hasErrors()){
			for(String propertyName: form.errors().keySet()){
				  List<ValidationError> errorsForThisProperty = form.errors().get(propertyName);
				  ValidationError firstErrorForThisProperty = errorsForThisProperty.get(0);
				  String errorMessage = firstErrorForThisProperty.message().concat(".").concat(propertyName);
				  String errormsg = null;
				  
				  if(errorMessage.equals("error.required.desc")){
					  errormsg = "Name is required";
				  }else if(errorMessage.equals("error.invalid.cost")){
					  errormsg = "Invalid value in cost";
				  }else if(errorMessage.equals("error.required.name")){
					  errormsg = "Description is required";
				  }
				  
				  flash().put("errormsg", errormsg);
				  return redirect(routes.FormController.getAll());
				}
		}
		
		

		Product product = Form.form(Product.class).bindFromRequest().get();
		Ebean.save(product);
		
		return redirect(routes.FormController.getAll());
	}

	public static Result getAll() {

		List<Product> products = Ebean.find(Product.class).findList();

		List<Product> filteredProducts = Ebean.filter(Product.class).sort("id").filter(products);

		return ok(formTest.render(filteredProducts));

	}

}

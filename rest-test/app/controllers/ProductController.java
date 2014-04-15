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
import play.libs.Json;
import play.mvc.*;
import views.html.*;
import views.html.helper.form;

public class ProductController extends Controller {

	public static Result index() {
		return ok(index.render("Productz"));
	}

	public static Result create() {
		Product prod = Form.form(Product.class).bindFromRequest().get();
		Ebean.save(prod);

		return ok();

	}

	public static Result getAll() {

		List<Product> products = Ebean.find(Product.class).findList();

		List<Product> filteredProducts = Ebean.filter(Product.class).sort("id").filter(products);

		return ok(Json.toJson(filteredProducts));

	}

	public static Result getProd(int id) {
		Product prod = Ebean.find(Product.class, id);
		return ok(Json.toJson(prod));
	}

	public static Result deleteProd(int id) {
		Product prod = Ebean.find(Product.class, id);
		Ebean.delete(prod);
		return ok();
	}

	public static Result updateProd(int id) {
		Product prod = Ebean.find(Product.class, id);
		Product form = Form.form(Product.class).bindFromRequest().get();

		prod.name = form.name;
		prod.desc = form.desc;
		prod.cost = form.cost;

		Ebean.update(prod);

		return ok();
	}

}

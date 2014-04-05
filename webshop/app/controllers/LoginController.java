package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

import model.Category;
import model.Product;
import model.User;
import play.*;
import play.data.*;
import play.db.*;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.*;
import play.mvc.Security;

@Transactional
public class LoginController extends Controller {
	
	public static Result createUser(){
		return ok(createUser.render("New user"));
	}
	
	public static Result creatingUser(){
		Map<String, String[]> form = request().body().asFormUrlEncoded();
		
		String name = form.get("name")[0];
		String email = form.get("email")[0];
		String address = form.get("address")[0];
		String phone = form.get("address")[0];
		String password = form.get("password")[0];
		String confPassword = form.get("confirm-password")[0];
		
		
		//check here if user already exist, or mail is already taken.
		TypedQuery<User> query = JPA.em().createQuery("SELECT c FROM User c WHERE c.email = :minEmail", User.class);
		query.setParameter("minEmail", email);
		List<User> users = query.getResultList();
		if(users.size() == 1){
			flash().put("User-exist", "yes");
			return ok(createUser.render("User exist."));
		}		
		
		//then check if password and confPass is same
		boolean checkPass = password.equals(confPassword);
		if(!checkPass){
			flash().put("pass-no-match", "yes");
			return ok(createUser.render("Password no match"));
		}
		
		//then place it in DB
		
		User newUser = new User();
		newUser.name = name;
		newUser.address = address;
		newUser.email = email;
		newUser.telephone_number = phone;
		newUser.password = password;
		
		JPA.em().persist(newUser);
		
		//Lastly, log in using the info the user gave
		
		
		session().put("username", newUser.name);
		session().put("id", Integer.toString(newUser.id));
		return ok(index.render(newUser.name));
	}
	
    public static Result logins(){
		return ok(login.render("Login"));
    	
    }
    
    public static Result loginouts(){
		session().clear();
		return redirect(routes.Application.index());
    	
    }
    
    public static Result loginForm(){
    	Map<String, String[]> form = request().body().asFormUrlEncoded();
		
		String username = form.get("email")[0];
		String password = form.get("password")[0];
		boolean usernameIsEmpty = "".equals(username);
		boolean passwordIsEmpty = "".equals(password);
		User currentUser = null;
		
		if(usernameIsEmpty && passwordIsEmpty){
			flash().put("login-failed", "yes");
			return redirect(routes.LoginController.loginForm());
		}
		
		if(usernameIsEmpty){
			flash().put("username-empty", "yes");
			return redirect(routes.LoginController.loginForm());
		}
		
		if(passwordIsEmpty){
			flash().put("password-empty", "yes");
			return redirect(routes.LoginController.loginForm());
		}
		

			TypedQuery<User> query = JPA.em().createQuery("SELECT c FROM User c WHERE c.email = :minEmail and c.password = :minPass", User.class);
			query.setParameter("minEmail", username);
			query.setParameter("minPass", password);
			List<User> users = query.getResultList();
				if(users.size() == 1){
					currentUser = users.get(0);
				}
				else if(users.size() == 0){
					flash().put("User-nonexisting", "yes");
					return redirect(routes.LoginController.loginForm());
					}
			
			session().put("username", currentUser.name);
			session().put("id", Integer.toString(currentUser.id));
			return ok(index.render(currentUser.name));
    }
}

package controllers;

import java.util.Map;

import play.*;
import play.data.*;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.*;
import play.mvc.Security;

public class Application extends Controller {
	private final static String user = "admin";
	private final static String pass = "admin";
	
	
    public static Result index() {
        return ok(index.render("Webshop v2.1"));
        
//        v1.3 	Inloggnings system typ.
//        v1.4 	La till create category och dess funktioner.
//        v1.5 	Ändrat upplägg på menyn i main. 
//        		Kvarstående att göra: shopping cart / Checkout(Order)
//        v1.6 	ShoppingCart kopplat och kan visa upp Session.get userns products mha. id.
//        		Kvarstående att göra: Checkout, User auto-login if new user, update/delete cat/prod.
//        v1.7	ShoppingCart kopplat och kan visa products i cart. Add options for del/update.
//        		Kvarstående att göra: skicka vidare shoppingCart, uppdatera ifall prod existerar.
//        							  Tabort från shoppingcart samtidigt som den lägger till i order.
//        v1.8	ShoppingCart fixat någorlunda, 99% klart. Måste testa olika scenario för att se efter bugg.
//        		Kvarstående att göra: skicka vidare shoppingCart till order.
//		  		Tabort från shoppingcart samtidigt som den lägger till i order.
//        v1.9	ShoppinCart och Order/CheckOut 99% klart. Kan lägga till och tabort i båda två.
//        		BuggTest och liknande. v2.0 Ska va redovisningsklar shiet.
        
//        		Fixa flash med main, universial funktion. 		FIXAT
//        		Fixa till text på meny. Lägg till creds			FIXAT
//        		Lägg till dummy categories och products.		TYP
//        		Bugg när man lägger till category 				FIXAT
        

//        v2.0	Redovisningsklar. Kan finnas möjliga buggar. Fixas i framtida lösningar! :)
        
//        v2.1	Viktors test visade delen som jag missade. Finns en check funktion, 
//        		som tittar slutligen om prod finns i lager innan order placeras.

        
//        		Creds:
//        		http://tympanus.net/codrops/2010/07/16/slide-down-box-menu/  	(Menu)
//        		http://www.24psd.com/dark-batman-css3-login-form/				(Login)
//        		http://pdalife.net/android/programmy/razvlecheniya/903-copy-paste-it.html	(Picture)
    }
}

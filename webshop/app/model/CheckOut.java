package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import play.db.jpa.JPA;

@Entity
public class CheckOut {
	
	@Id
	@GeneratedValue
	public int id;
	public int prod_id;
	public int user_id;
	public int quantity;
	public int order_date;
	
	public CheckOut() {
		userOrderList = new ArrayList<User>();
	}
	
	@ManyToMany()
	@JoinTable(name="CheckOut_User",joinColumns=@JoinColumn(name="OrderUserList_id"), inverseJoinColumns=@JoinColumn(name="userOrderList_id"))
	public List<User> userOrderList;
	
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		Product prod = JPA.em().find(Product.class, prod_id);
		
		return String.format(
				"Name of product: %s, Cost: %d, Quantity: %d, Order date: %d, Total cost:%d", 
				prod.name, prod.cost, quantity, order_date, (prod.cost*quantity));
	}
}

package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class ShoppingCart {

	@Id
	@GeneratedValue
	public int id;
	public String name;
	public int cost;
	public String description;
	public int rrp;
	public int quantity;

	public ShoppingCart() {
		userList = new ArrayList<User>();
	}
	
	
	@ManyToMany()
	@JoinTable(name="ShoppingCart_User",joinColumns=@JoinColumn(name="cartList_id"), inverseJoinColumns=@JoinColumn(name="userList_id"))

	public List<User> userList;
	
}

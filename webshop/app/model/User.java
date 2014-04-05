package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	public int id;
	public String name;
	public String email;
	public String address;
	public String telephone_number;	
	public String password;

	public User() {
		cartList = new ArrayList<ShoppingCart>();
		orderUserList = new ArrayList<CheckOut>();
		
	}
	
	@ManyToMany(mappedBy = "userList")
	public List<ShoppingCart> cartList;
	
	@ManyToMany(mappedBy = "userOrderList")
	public List<CheckOut> orderUserList;

	public int getUserId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getPhonenumber() {
		return telephone_number;
	}
	
	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return String.format("Id= %d \t Name: %s, Email: %s, Address: %s, Phone Number: %s, Password: %s", 
				id, name, email, address, telephone_number, password);
	}
}

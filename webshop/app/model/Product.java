package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import scala.Array;

@Entity
public final class Product {
	
	@Id
	@GeneratedValue
	public int id;
	public String name;
	public int cost;
	public String description;
	public int rrp;
	public int quantity;

	public Product(){
		catList = new ArrayList<Category>();
	}
	
	@ManyToMany()
	@JoinTable(name="category_product",joinColumns=@JoinColumn(name="product_id"), inverseJoinColumns=@JoinColumn(name="category_id"))
	public List<Category> catList;
	

	
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public int getCost() {
		return cost;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getRRP() {
		return rrp;
	}
	
	public int getQuantity() {
		return quantity;
	}

}


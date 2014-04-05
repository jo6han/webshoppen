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

@Entity
public class Category {
	
	@Id
	@GeneratedValue
	public int id;
	public String name;
	public int staff_id;
	
	public Category() {
		prodList = new ArrayList<Product>();
	}
	
	@ManyToMany(mappedBy = "catList")
	public List<Product> prodList;
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public int getStaffId() {
		return staff_id;
	}
}

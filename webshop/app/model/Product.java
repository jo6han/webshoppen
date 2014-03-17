package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public final class Product {
	
	@Id
	public Integer productId;
	public String name;
	public Integer cost;

	public Product(Integer productId, String name, Integer cost){
		this.productId = productId;
		this.name = name;
		this.cost = cost;
	}
	

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}
	
	public int getCost() {
		return cost;
	}

}


package model;

public final class Product {
	
	private final int productId;
	private final String name;
//	private final String description;
	private final int cost;
//	private final int RRP;
//	private	int quantity;
	
	public Product(int productId, String name, int cost){
		this.productId = productId;
		this.name = name;
		this.cost = cost;
	}
	
//	public Product(int productId, String name, String description, int cost, int RRP, int quantity) {
//		this.productId = productId;
//		this.name = name;
//		this.description = description;
//		this.cost = cost;
//		this.RRP = RRP;	
//		this.quantity = quantity;
//	}

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}
	
//	public String getDescription() {
//		return description;
//	}
	
	public int getCost() {
		return cost;
	}
	
//	public int getRRP() {
//		return RRP;
//	}
//	
//	public int getQuantity() {
//		return quantity;
//	}

//	@Override
//	public String toString() {
//		return String.format(
//				"Id= %d \t Name: %s, Description: %s, Cost: %d, RRP: %d, Quantity: %d", 
//				productId, name, description, cost, RRP, quantity);
//	}
//
//	public String toStringCart() {
//		return String.format(
//				"Id= %d \t Name: %s, amount: %d", 
//				productId, name, quantity);
//	}
}


package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import play.data.validation.Constraints.Required;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	public int id;
	@Required
	public String name;
	@Required
	public String desc;
	@Required
	public int cost;
	
	public Product(){
		
	}

}

package tn.esprit.auction.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ProductRecommended
 *
 */
@Entity
@Table(name="t_product_recommended")

public class ProductRecommended implements Serializable {

	
	private Integer id;
	private String category;
	private String name;
	private static final long serialVersionUID = 1L;

	public ProductRecommended() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}

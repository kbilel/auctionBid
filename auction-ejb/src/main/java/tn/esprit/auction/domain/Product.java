package tn.esprit.auction.domain;

import java.util.List;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity
@Table(name="t_product")

public class Product implements Serializable {

	
	private Integer id;
	private String name;
	private Integer quantity;
	private String description;
	private String category;
	private Integer price;
	private Byte[] imageByte;
	private String imageUrl;
	private static final long serialVersionUID = 1L;
	private List<Review> reviews;
	private Auction auction;
	List<Order> orders;

	public Product() {
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
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Column (name="image_byte")
	public Byte[] getImageByte() {
		return imageByte;
	}
	public void setImageByte(Byte[] imageByte) {
		this.imageByte = imageByte;
	}
	@Column (name="image_url")
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@OneToMany(mappedBy="product")
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	@OneToOne (mappedBy="product")
	public Auction getAuction() {
		return auction;
	}
	public void setAuction(Auction auction) {
		this.auction = auction;
	}
	
	@OneToMany(mappedBy="product")
	public List <Order> getOrders() {
		return orders;
	}

	public void setOrders(List <Order> orders) {
		this.orders = orders;
	}
   
}

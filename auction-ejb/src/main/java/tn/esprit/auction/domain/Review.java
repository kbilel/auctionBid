package tn.esprit.auction.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import tn.esprit.auction.domain.ReviewPK;

/**
 * Entity implementation class for Entity: Review
 *
 */
@Entity
@Table(name="t_review")

public class Review implements Serializable {

	
	private String text;
	private ReviewPK reviewPK;
	private static final long serialVersionUID = 1L;
	private Client client;
	private Product product;
	public Review() {
		super();
	}   
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}   
	@EmbeddedId
	public ReviewPK getReviewPK() {
		return this.reviewPK;
	}

	public void setReviewPK(ReviewPK reviewPK) {
		this.reviewPK = reviewPK;
	}
	@ManyToOne
	@JoinColumn(name="id_client",referencedColumnName="id",insertable=false,updatable=false)
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@ManyToOne
	@JoinColumn(name="id_product",referencedColumnName="id",insertable=false,updatable=false)

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Review(String text, Client client, Product product) {
		super();
		this.text = text;
		this.client = client;
		this.product = product;
		this.reviewPK= new ReviewPK(product.getId(), client.getId());
	}
   
}

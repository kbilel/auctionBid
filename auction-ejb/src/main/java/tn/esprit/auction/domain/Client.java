package tn.esprit.auction.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.util.List;

import javax.management.relation.Role;
import javax.persistence.*;

import tn.esprit.auction.domain.User;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity
@Table(name="t_client")

public class Client extends User implements Serializable {

	
	private Integer numberTockens;
	private static final long serialVersionUID = 1L;
	private List<Payement> payements;
	private List<Message> messages;
	private List<Review> reviews;
	private List<Bid>bids;
	private List<CategoryInterestedByClients>categoryInterestedByClients;
	List<Order> orders;
	
	
	public Client() {
		super();
	}   
	@Column (name="number_tockens")
	public Integer getNumberTockens() {
		return this.numberTockens;
	}

	public void setNumberTockens(Integer numberTockens) {
		this.numberTockens = numberTockens;
	}
	@OneToMany(mappedBy="client")
	public List<Payement> getPayements() {
		return payements;
	}
	public void setPayements(List<Payement> payementts) {
		this.payements = payementts;
	}
	@OneToMany(mappedBy="client")
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> message) {
		this.messages = message;
	}
	@OneToMany (mappedBy="client")
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	@OneToMany (mappedBy="client")
	public List<Bid> getBids() {
		return bids;
	}
	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}
	@OneToMany (mappedBy="client",fetch=FetchType.EAGER)
	public List<CategoryInterestedByClients> getCategoryInterestedByClients() {
		return categoryInterestedByClients;
	}
	public void setCategoryInterestedByClients(
			List<CategoryInterestedByClients> categoryInterestedByClients) {
		this.categoryInterestedByClients = categoryInterestedByClients;
	}
	
	@OneToMany(mappedBy="client")
	public List <Order> getOrders() {
		return orders;
	}

	public void setOrders(List <Order> orders) {
		this.orders = orders;
	}
   
}

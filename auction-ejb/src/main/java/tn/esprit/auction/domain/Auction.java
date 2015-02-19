package tn.esprit.auction.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;
import java.util.List;

import javax.management.relation.Role;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Auction
 *
 */
@Entity
@Table(name="t_auction")

public class Auction implements Serializable {

	
	private Integer id;
	private Date auctionStartingDate;
	private Integer auctionStartingPrice;
	private Date auctionEndDate;
	private static final long serialVersionUID = 1L;
	private List<Message> messages;
	private Product  product;

	public Auction() {
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
	@Column (name="auction_starting_date")
	@Temporal (TemporalType.TIMESTAMP)
	public Date getAuctionStartingDate() {
		return this.auctionStartingDate;
	}

	public void setAuctionStartingDate(Date auctionStartingDate) {
		this.auctionStartingDate = auctionStartingDate;
	}   
	@Column (name="auction_starting_price")
	public Integer getAuctionStartingPrice() {
		return this.auctionStartingPrice;
	}

	public void setAuctionStartingPrice(Integer auctionStartingPrice) {
		this.auctionStartingPrice = auctionStartingPrice;
	}   
	@Column (name="auction_end_date")
	@Temporal (TemporalType.TIMESTAMP)
	public Date getAuctionEndDate() {
		return this.auctionEndDate;
	}

	public void setAuctionEndDate(Date auctionEndDate) {
		this.auctionEndDate = auctionEndDate;
	}
	@OneToMany(mappedBy="auction")
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> message) {
		this.messages = message;
	}
	@OneToOne
	@JoinColumn(name="id_product")
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}

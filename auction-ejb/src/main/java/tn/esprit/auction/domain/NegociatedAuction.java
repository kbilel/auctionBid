package tn.esprit.auction.domain;

import java.io.Serializable;
import java.lang.Integer;

import javax.persistence.*;

import tn.esprit.auction.domain.Auction;
import tn.esprit.auction.domain.Client;

/**
 * Entity implementation class for Entity: NegociatedAuction
 *
 */
@Entity
@Table(name="t_negociated_auction")

public class NegociatedAuction extends Auction implements Serializable {

	
	private Integer fixedMinimumPrice;
	private Integer currentBidPrice;
	private Client currentWinner;
	private static final long serialVersionUID = 1L;

	public NegociatedAuction() {
		super();
	}   
	@Column (name="fixed_minimum_price")
	public Integer getFixedMinimumPrice() {
		return this.fixedMinimumPrice;
	}

	public void setFixedMinimumPrice(Integer fixedMinimumPrice) {
		this.fixedMinimumPrice = fixedMinimumPrice;
	}   
	@Column (name="current_bid_price")
	public Integer getCurrentBidPrice() {
		return this.currentBidPrice;
	}

	public void setCurrentBidPrice(Integer currentBidPrice) {
		this.currentBidPrice = currentBidPrice;
	}  
	@Column (name="current_winner")
	public Client getCurrentWinner() {
		return this.currentWinner;
	}

	public void setCurrentWinner(Client currentWinner) {
		this.currentWinner = currentWinner;
	}
   
}

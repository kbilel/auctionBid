package tn.esprit.auction.domain;

import java.io.Serializable;
import java.lang.Integer;

import javax.persistence.*;

import tn.esprit.auction.domain.Auction;
import tn.esprit.auction.domain.Client;

/**
 * Entity implementation class for Entity: EnglishAuction
 *
 */
@Entity
@Table(name="t_english_auction")
@DiscriminatorValue(value="English Auction")
public class EnglishAuction extends Auction implements Serializable {

	
	private Client CurrentWinner;
	private Integer CurrentBidValue;
	private static final long serialVersionUID = 1L;

	public EnglishAuction() {
		super();
	}   
	@Column (name="current_winner")
	public Client getCurrentWinner() {
		return this.CurrentWinner;
	}

	public void setCurrentWinner(Client CurrentWinner) {
		this.CurrentWinner = CurrentWinner;
	}   
	@Column (name="current_bid_value")
	public Integer getCurrentBidValue() {
		return this.CurrentBidValue;
	}

	public void setCurrentBidValue(Integer CurrentBidValue) {
		this.CurrentBidValue = CurrentBidValue;
	}
   
}

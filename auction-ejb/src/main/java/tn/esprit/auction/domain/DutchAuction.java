package tn.esprit.auction.domain;

import java.io.Serializable;
import java.lang.Integer;



import javax.persistence.*;

import tn.esprit.auction.domain.Auction;

/**
 * Entity implementation class for Entity: DutchAuction
 *
 */
@Entity
@Table(name="t_dutch_auction")
@DiscriminatorValue(value="Dutch Auction")
public class DutchAuction extends Auction implements Serializable {

	
	private Integer currentBidPrice;
	private Integer decreaseValue;
	private Integer decreaseTimeValue;
	private static final long serialVersionUID = 1L;

	public DutchAuction() {
		super();
	}   
	@Column (name="current_bid_price")
	public Integer getCurrentBidPrice() {
		return this.currentBidPrice;
	}

	public void setCurrentBidPrice(Integer currentBidPrice) {
		this.currentBidPrice = currentBidPrice;
	}  
	@Column (name="decrease_value")
	public Integer getDecreaseValue() {
		return this.decreaseValue;
	}

	public void setDecreaseValue(Integer decreaseValue) {
		this.decreaseValue = decreaseValue;
	}
	@Column (name="decrease_time_value")
	public Integer getDecreaseTimeValue() {
		return decreaseTimeValue;
	}
	public void setDecreaseTimeValue(Integer decreaseTimeValue) {
		this.decreaseTimeValue = decreaseTimeValue;
	}   

	
	
   
}

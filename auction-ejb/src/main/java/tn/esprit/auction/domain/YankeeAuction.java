package tn.esprit.auction.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import tn.esprit.auction.domain.Auction;

/**
 * Entity implementation class for Entity: YankeeAuction
 *
 */
@Entity
@Table(name="t_yankee_auction")
@DiscriminatorValue(value="Yankee Auction")
public class YankeeAuction extends Auction implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private List<Bid>bids;

	public YankeeAuction() {
		super();
	}
@OneToMany(mappedBy="yankeeAuction")
	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}
   
}

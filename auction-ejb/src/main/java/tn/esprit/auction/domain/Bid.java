package tn.esprit.auction.domain;

import java.io.Serializable;
import java.lang.Integer;

import javax.persistence.*;

import tn.esprit.auction.domain.BidPK;

/**
 * Entity implementation class for Entity: Bid
 *
 */
@Entity
@Table(name="t_bid")

public class Bid implements Serializable {

	
	private BidPK bidPK;
	private Integer bidValue;
	private static final long serialVersionUID = 1L;
	private Client client;
	private YankeeAuction yankeeAuction;

	public Bid() {
		super();
	} 
	@EmbeddedId
	public BidPK getBidPK() {
		return this.bidPK;
	}

	public void setBidPK(BidPK bidPK) {
		this.bidPK = bidPK;
	}   
	@Column(name="bid_value")
	public Integer getBidValue() {
		return this.bidValue;
	}

	public void setBidValue(Integer bidValue) {
		this.bidValue = bidValue;
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
	@JoinColumn(name="id_yankee_auction",referencedColumnName="id",insertable=false,updatable=false)

	public YankeeAuction getYankeeAuction() {
		return yankeeAuction;
	}
	public void setYankeeAuction(YankeeAuction yankeeAuction) {
		this.yankeeAuction = yankeeAuction;
	}
	public Bid(Integer bidValue, Client client, YankeeAuction yankeeAuction) {
		super();
		this.bidValue = bidValue;
		this.client = client;
		this.yankeeAuction = yankeeAuction;
		this.bidPK=new BidPK(client.getId(), yankeeAuction.getId());
	}
   
}

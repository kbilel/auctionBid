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
@Table(name="t_agregate_auction")
@DiscriminatorValue(value="Agregate Auction")
public class AgregateAuction extends Auction implements Serializable {

	

	private static final long serialVersionUID = 1L;

	public AgregateAuction() {
		super();
	} 
   
}

package tn.esprit.auction.services.gestion.bid;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.auction.domain.Bid;

@Remote
public interface BidServicesRemote {
	Boolean addBid(Bid bid );
	Boolean updateBid(Bid bid);
	Boolean deleteBid(Bid bid);
	Bid findBidById(Integer idBid);
	List<Bid>findAllBids();
	
}

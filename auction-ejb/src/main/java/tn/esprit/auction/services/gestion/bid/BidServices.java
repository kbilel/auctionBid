package tn.esprit.auction.services.gestion.bid;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.auction.domain.Bid;

/**
 * Session Bean implementation class BidServices
 */
@Stateless
@LocalBean
public class BidServices implements BidServicesRemote, BidServicesLocal {


	@PersistenceContext(unitName="auction-ejb")
	EntityManager entityManager;
    public BidServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addBid(Bid bid) {
		try {
			entityManager.persist(bid);
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Boolean updateBid(Bid bid) {
		try {
			entityManager.merge(bid);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteBid(Bid bid) {
		try {
			
			
			entityManager.remove(entityManager.merge(bid));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//hello moto :Dhtrh

	@Override
	public Bid findBidById(Integer idBid) {
		Bid bid=null;
		try {
			bid=entityManager.find(Bid.class, idBid);
		
		} catch (Exception e) {
			
		}
		return bid;
	}

	@Override
	public List<Bid> findAllBids() {
		Query query=entityManager.createQuery("select b from Bid b ");
		return query.getResultList();
	}

	

}

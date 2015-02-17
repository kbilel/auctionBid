package tn.esprit.auction.services.gestion.auction;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.auction.domain.Auction;
import tn.esprit.auction.domain.EnglishAuction;

/**
 * Session Bean implementation class AuctionServices
 */
@Stateless
@LocalBean
public class AuctionServices implements AuctionServicesRemote, AuctionServicesLocal {


	@PersistenceContext(unitName="auction-ejb")
	EntityManager entityManager;
    public AuctionServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addAuction(Auction auction) {
		try {
			entityManager.persist(auction);
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Boolean updateAuction(Auction auction) {
		try {
			entityManager.merge(auction);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteAuction(Auction auction) {
		try {
			
			
			entityManager.remove(entityManager.merge(auction));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Auction findAuctionById(Integer idAuction) {
		Auction auction=null;
		try {
			auction=entityManager.find(Auction.class, idAuction);
		
		} catch (Exception e) {
			
		}
		return auction;
	}

	@Override
	public List<Auction> findAllAuctions() {
		Query query=entityManager.createQuery("select a from Auction a ");
		return query.getResultList();
	}

	@Override
	public List<EnglishAuction> findAllEnglishAuctions() {
		Query query=entityManager.createQuery("select a from EnglishAuction a ");
		if (query.getResultList()!=null)
		System.out.println("ejb find english auction is not null");
		return query.getResultList();
		
	}

}

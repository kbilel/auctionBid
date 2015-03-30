package tn.esprit.auction.services;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.auction.domain.Auction;
import tn.esprit.auction.domain.Client;
import tn.esprit.auction.domain.EnglishAuction;
import tn.esprit.auction.domain.Product;
import tn.esprit.auction.domain.User;

/**
 * Session Bean implementation class Alimentation
 */
@Singleton
@LocalBean
@Startup
public class Alimentation {
	@PersistenceContext
	EntityManager em;

	public Alimentation() {
		// TODO Auto-generated constructor stub
	}

	// @PostConstruct
	public void addUser() {
		User user = new User();
		user.setUserName("foulen");
		em.persist(user);
		Client client = new Client();
		client.setUserName("dev");
		em.persist(client);
		EnglishAuction auction=new EnglishAuction();
		auction.setAuctionStartingPrice(500);
		em.persist(auction);
		Product product=new Product();
		product.setName("car");
		em.persist(product);
	}

}

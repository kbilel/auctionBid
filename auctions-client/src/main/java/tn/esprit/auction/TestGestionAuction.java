package tn.esprit.auction;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.auction.domain.AgregateAuction;
import tn.esprit.auction.domain.Auction;
import tn.esprit.auction.domain.DutchAuction;
import tn.esprit.auction.domain.EnglishAuction;
import tn.esprit.auction.domain.NegociatedAuction;
import tn.esprit.auction.domain.YankeeAuction;
import tn.esprit.auction.services.gestion.auction.AuctionServicesRemote;

public class TestGestionAuction {
	static AuctionServicesRemote remote;
	public static void doAddAuction(AuctionServicesRemote remote){

		EnglishAuction auction=new EnglishAuction();
		auction.setAuctionStartingPrice(500);
		if(remote.addAuction(auction)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...add");

	}
	public static void doUpdateAuction(AuctionServicesRemote remote){

		Auction auction=remote.findAuctionById(2);
		auction.setAuctionStartingPrice(444);
		if(remote.updateAuction(auction)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...");

	}
	public static void doDeleteAuction(AuctionServicesRemote remote){

		Auction auction=remote.findAuctionById(1);
		if (auction ==null)
System.out.println("auction null");
		if(remote.deleteAuction(auction)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...delete");

	}
	public static void doFindAllEnglishAuction(){
		List<EnglishAuction> englishAuctions= remote.findAllEnglishAuctions();
		if (englishAuctions==null)
			System.out.println("liste e a vide");
		else
			System.out.println(""+englishAuctions.size());
	}
	public static void main(String[] args) {
		
		
		try {
			Context context=new InitialContext();
			remote=(AuctionServicesRemote) context.lookup("auction-ejb/AuctionServices!tn.esprit.auction.services.gestion.auction.AuctionServicesRemote");
				} catch (NamingException e) {
		System.out.println("erreur jndi ... ");
			e.printStackTrace();
		}
		
doAddAuction(remote);
doAddAuction(remote);
doAddAuction(remote);
		//doUpdateAuction(remote);
	//doDeleteAuction(remote);
	//doFindAllEnglishAuction();
	}
}

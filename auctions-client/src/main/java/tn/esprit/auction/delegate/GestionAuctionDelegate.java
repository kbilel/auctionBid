package tn.esprit.auction.delegate;

import java.util.List;

import tn.esprit.auction.domain.Auction;
import tn.esprit.auction.domain.Auction;
import tn.esprit.auction.domain.EnglishAuction;
import tn.esprit.auction.locator.ServiceLocator;
import tn.esprit.auction.services.gestion.auction.AuctionServicesRemote;

public class GestionAuctionDelegate {


	static AuctionServicesRemote remote;
	private static final String jndi="auction-ejb/AuctionServices!tn.esprit.auction.services.gestion.auction.AuctionServicesRemote"; 

	private static AuctionServicesRemote getProxy(){
		return (AuctionServicesRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
	public  static Boolean doAddAuction(Auction auction){
	return getProxy().addAuction(auction);
	
}
	public  static Boolean doUpdateAuction(Auction auction)
	{
		return getProxy().updateAuction(auction);
	}
	public  static Boolean doDeleteAuction(Auction auction)
	{
		return getProxy().deleteAuction(auction);
	}
	public  static Auction doFindAuctionById(Integer idAuction)
	{
		return getProxy().findAuctionById(idAuction);
	}
	
	public static List<Auction> doFindAllAuctions(){
		return getProxy().findAllAuctions();
	}	
	public static List<EnglishAuction> doFindAllEnglishAuctions(){
		return getProxy().findAllEnglishAuctions();
	}	
}

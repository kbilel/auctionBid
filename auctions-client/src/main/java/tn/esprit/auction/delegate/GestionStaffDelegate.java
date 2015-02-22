package tn.esprit.auction.delegate;

import java.util.List;

import tn.esprit.auction.domain.BookKeeper;
import tn.esprit.auction.domain.DeliveryMan;
import tn.esprit.auction.domain.Manager;
import tn.esprit.auction.domain.StockManager;
import tn.esprit.auction.locator.ServiceLocator;
import tn.esprit.auction.services.gestion.user.GestionStaffRemote;
import tn.esprit.auction.services.gestion.user.UserServicesRemote;

public class GestionStaffDelegate {

	static GestionStaffRemote remote;
	private static final String jndi="auction-ejb/GestionStaff!tn.esprit.auction.services.gestion.user.GestionStaffRemote"; 

	private static GestionStaffRemote  getProxy(){
		return (GestionStaffRemote ) ServiceLocator.getInstance().getProxy(jndi);
	}
	
	public  static Boolean doAddManager(Manager manager){
	return getProxy().addManager(manager);
	}
	public  static Boolean doUpdateManager(Manager manager){
	return getProxy().updateManager(manager);
	}
	public  static Boolean doDeleteManager(Manager manager){
	return getProxy().deleteManager(manager);
	}
	public  static Manager doFindManagerById(Integer idManager){
	return getProxy().findManagerById(idManager);
	}
	public  static List<Manager> doFindAllManagerByName(String name){
	return getProxy().findAllManagerByName(name);
	}
	public  static List<Manager> doFindAllManagers(){
	return getProxy().findAllManagers();
	}
	public  static Boolean doAddStockManager(StockManager stockManager) {
	return getProxy().addStockManager(stockManager);
	}
	public  static Boolean doUpdateStockManager(StockManager stockManager){
	return getProxy().updateStockManager(stockManager);
	}
	public  static Boolean doDeleteStockManager(StockManager stockManager){
	return getProxy().deleteStockManager(stockManager);
	}
	
	public  static StockManager doFindStockManagerById(Integer idStockManager){
	return getProxy().findStockManagerById(idStockManager);
	}
	public  static List<StockManager> doFindAllStockManagerByName(String name){
	return getProxy().findAllStockManagerByName(name);
	}
	public  static List<StockManager> doFindAllStockManager(){
	return getProxy().findAllStockManager();
	}
	public  static Boolean doAddDeliveryMan (DeliveryMan deliveryMan  ){
	return getProxy().addDeliveryMan(deliveryMan);
	}
	public  static Boolean doUpdateDeliveryMan (DeliveryMan deliveryMan){
	return getProxy().updateDeliveryMan(deliveryMan);
	}
	public  static Boolean doDeleteDeliveryMan (DeliveryMan deliveryMan){
	return getProxy().deleteDeliveryMan(deliveryMan);
	}
	public  static DeliveryMan doFindDeliveryManById(Integer IdDeliveryMan){
	return getProxy().findDeliveryManById(IdDeliveryMan);
	}
	public  static List<DeliveryMan> doFindAllDeliveryManByName(String name){
	return getProxy().findAllDeliveryManByName(name);
	}
	public  static List<DeliveryMan> doFindAllDeliveryMan(){
	return getProxy().findAllDeliveryMan();
	}
	public  static Boolean doAddBookKeeper(BookKeeper bookKeeper  ){
	return getProxy().addBookKeeper(bookKeeper);
	}
	public  static Boolean doUpdateBookKeeper(BookKeeper bookKeeper ){
	return getProxy().updateBookKeeper(bookKeeper);
	}
	public  static Boolean doDeleteBookKeeper (BookKeeper bookKeeper ){
	return getProxy().deleteBookKeeper(bookKeeper);
	}
	public  static BookKeeper doFindBookKeeperById(Integer IdBookKeeper){
	return getProxy().findBookKeeperById(IdBookKeeper);
	}
	public  static List<BookKeeper> doFindAllBookkeeperByName(String name){
	return getProxy().findAllBookkeeperByName(name);
	}
	public  static List<BookKeeper> doFindAllBookKeeper(){
		return getProxy().findAllBookKeeper();
	}
}

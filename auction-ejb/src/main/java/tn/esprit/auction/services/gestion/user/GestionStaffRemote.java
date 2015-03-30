package tn.esprit.auction.services.gestion.user;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.auction.domain.Manager;
import tn.esprit.auction.domain.StockManager;
import tn.esprit.auction.domain.DeliveryMan;
import tn.esprit.auction.domain.BookKeeper;



@Remote
public interface GestionStaffRemote {
	Boolean addManager(Manager Manager);
	Boolean updateManager(Manager manager);
	Boolean deleteManager(Manager manager);
	Manager findManagerById(Integer idManager);
	List<Manager> findAllManagerByName(String name);
	List<Manager> findAllManagers();
	
	Boolean addStockManager(StockManager stockManager);
	Boolean updateStockManager(StockManager stockManager);
	Boolean deleteStockManager(StockManager stockManager);
	StockManager findStockManagerById(Integer idStockManager);
	List<StockManager> findAllStockManagerByName(String name);
	List<StockManager> findAllStockManager();
	
	Boolean addDeliveryMan(DeliveryMan deliveryMan);
	Boolean updateDeliveryMan (DeliveryMan deliveryMan);
	Boolean deleteDeliveryMan (DeliveryMan deliveryMan);
	DeliveryMan findDeliveryManById(Integer IdDeliveryMan);
	List<DeliveryMan> findAllDeliveryManByName(String name);
	List<DeliveryMan> findAllDeliveryMan();
	
	Boolean addBookKeeper(BookKeeper bookKeeper  );
	Boolean updateBookKeeper(BookKeeper bookKeeper );
	Boolean deleteBookKeeper (BookKeeper bookKeeper );
	BookKeeper findBookKeeperById(Integer IdBookKeeper);
	List<BookKeeper> findAllBookkeeperByName(String name);
	List<BookKeeper> findAllBookKeeper();
}

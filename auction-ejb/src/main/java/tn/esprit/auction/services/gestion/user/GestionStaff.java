package tn.esprit.auction.services.gestion.user;

import java.util.List;






import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;





import tn.esprit.auction.domain.BookKeeper;
import tn.esprit.auction.domain.DeliveryMan;
import tn.esprit.auction.domain.Manager;
import tn.esprit.auction.domain.StockManager;
import tn.esprit.auction.domain.User;


@Stateless
public class GestionStaff implements GestionStaffRemote, GestionStaffLocal {
	@PersistenceContext(unitName="auction-ejb")
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public GestionStaff() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addManager(Manager manager) {
		try {
			entityManager.persist(manager);
			System.out.println("ok ejb");
			
			return true;
		} catch (Exception e) {
			System.out.println("erreur ejb");
			return false;
			
		}
	}

	@Override
	public Boolean updateManager(Manager manager) {
		try {
			entityManager.merge(manager);
			
			return true;
		} catch (Exception e) {
			System.out.println("exception update manager");
			return false;
		}
	}

	

	@Override
	public Boolean deleteManager(Manager manager) {
try {
	entityManager.remove(entityManager.merge(manager));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	
	}

	@Override
	public Manager findManagerById(Integer idManager) {
		Manager manager=null;
		try {
			manager=entityManager.find(Manager.class, idManager);
		
		} catch (Exception e) {
			
		}
		return manager;
	
	}

	@Override
	public List<Manager> findAllManagerByName(String name) {
		Query query = entityManager.createQuery("select m from Manager m where m.userName=:name");

				query.setParameter("name", name);
		return query.getResultList();
		
	
	}

	@Override

	public List<Manager>findAllManagers() {
		Query query=entityManager.createQuery("select u from Manager u ");
		return query.getResultList();
	}
	
	@Override
	public Boolean addStockManager(StockManager stockManager) {
		try {
			entityManager.persist(stockManager);
			System.out.println("ok ejb");
			
			return true;
		} catch (Exception e) {
			System.out.println("erreur ejb");
			return false;
			
		}
	}

	@Override
	public Boolean updateStockManager(StockManager stockManager) {
		try {
			entityManager.merge(stockManager);
			
			return true;
		} catch (Exception e) {
			System.out.println("exception update manager");
			return false;
		}
	}

	@Override
	public Boolean deleteStockManager(StockManager stockManager) {
		try {
			entityManager.remove(entityManager.merge(stockManager));
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
	}

	@Override
	public StockManager findStockManagerById(Integer idStockManager) {
		StockManager stockManager =null;
		try {
			stockManager=entityManager.find(StockManager.class, idStockManager);
		
		} catch (Exception e) {
			
		}
		
		return stockManager;
	
	}

	@Override
	public List<StockManager> findAllStockManagerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StockManager> findAllStockManager() {
		Query query=entityManager.createQuery("select s from StockManager s ");
		return query.getResultList();
	}

	@Override
	public Boolean addDeliveryMan(DeliveryMan deliveryMan) {
		try {
			entityManager.persist(deliveryMan);
			System.out.println("ok ejb");
			
			return true;
		} catch (Exception e) {
			System.out.println("erreur ejb");
			return false;
			
		}
	}

	@Override
	public Boolean updateDeliveryMan(DeliveryMan deliveryMan) {
		try {
			entityManager.merge(deliveryMan);
			
			return true;
		} catch (Exception e) {
			System.out.println("exception update delivery Man");
			return false;
		}
	}

	@Override
	public Boolean deleteDeliveryMan(DeliveryMan deliveryMan) {
		try {
			entityManager.remove(entityManager.merge(deliveryMan));
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
	}

	@Override
	public DeliveryMan findDeliveryManById(Integer IdDeliveryMan) {
		DeliveryMan deliveryMan =null;
		try {
			deliveryMan =entityManager.find(DeliveryMan.class, IdDeliveryMan);
		
		} catch (Exception e) {
			
		}
		
		return deliveryMan;
	}

	@Override
	public List<DeliveryMan> findAllDeliveryManByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DeliveryMan> findAllDeliveryMan() {
		Query query=entityManager.createQuery("select d from DeliveryMan d ");
		return query.getResultList();
	}

	@Override
	public Boolean addBookKeeper(BookKeeper bookKeeper) {
		try {
			entityManager.persist(bookKeeper);
			System.out.println("ok ejb");
			
			return true;
		} catch (Exception e) {
			System.out.println("erreur ejb");
			return false;
			
		}
	}

	@Override
	public Boolean updateBookKeeper(BookKeeper bookKeeper) {
		try {
			entityManager.remove(entityManager.merge(bookKeeper));
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
	}

	@Override
	public Boolean deleteBookKeeper(BookKeeper bookKeeper) {
		try {
			entityManager.remove(entityManager.merge(bookKeeper));
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
	}

	@Override
	public BookKeeper findBookKeeperById(Integer IdBookKeeper) {
		
		BookKeeper bookKeeper =null;
			try {
				 bookKeeper =entityManager.find(BookKeeper.class, IdBookKeeper);
			
			} catch (Exception e) {
				
			}
			
			return  bookKeeper;
	}

	@Override
	public List<BookKeeper> findAllBookkeeperByName(String name) {
		Query query = entityManager.createQuery("select u from User b where u.userName=:name");

		query.setParameter("name", name);
return query.getResultList();

	}

	@Override
	public List<BookKeeper> findAllBookKeeper() {
		Query query=entityManager.createQuery("select b from BookKeeper b ");
		return query.getResultList();
	}





}

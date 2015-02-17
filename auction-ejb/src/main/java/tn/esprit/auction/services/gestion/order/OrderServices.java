package tn.esprit.auction.services.gestion.order;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.auction.domain.Order;

/**
 * Session Bean implementation class OrderServices
 */
@Stateless
@LocalBean
public class OrderServices implements OrderServicesRemote, OrderServicesLocal {


	@PersistenceContext(unitName="auction-ejb")
	EntityManager entityManager;
    public OrderServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addOrder(Order order) {
		try {
			entityManager.persist(order);
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Boolean updateOrder(Order order) {
		try {
			entityManager.merge(order);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteOrder(Order order) {
		try {
			
			
			entityManager.remove(entityManager.merge(order));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Order findOrderById(Integer idOrder) {
		Order order=null;
		try {
			order=entityManager.find(Order.class, idOrder);
		
		} catch (Exception e) {
			
		}
		return order;
	}

	@Override
	public List<Order> findAllOrders() {
		Query query=entityManager.createQuery("select o from Order o ");
		return query.getResultList();
	}

	


}

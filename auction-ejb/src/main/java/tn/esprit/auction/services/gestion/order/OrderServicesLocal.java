package tn.esprit.auction.services.gestion.order;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.auction.domain.Order;

@Local
public interface OrderServicesLocal {
	Boolean addOrder(Order order );
	Boolean updateOrder(Order order);
	Boolean deleteOrder(Order order);
	Order findOrderById(Integer idOrder);
	List<Order>findAllOrders();
	
}

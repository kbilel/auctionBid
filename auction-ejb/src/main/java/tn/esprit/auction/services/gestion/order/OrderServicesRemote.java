package tn.esprit.auction.services.gestion.order;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.auction.domain.Order;

@Remote
public interface OrderServicesRemote {
	Boolean addOrder(Order order );
	Boolean updateOrder(Order order);
	Boolean deleteOrder(Order order);
	Order findOrderById(Integer idOrder);
	List<Order>findAllOrders();
	
}

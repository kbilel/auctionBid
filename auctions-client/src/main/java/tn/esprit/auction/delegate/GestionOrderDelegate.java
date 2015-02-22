package tn.esprit.auction.delegate;

import java.util.List;

import tn.esprit.auction.domain.Order;
import tn.esprit.auction.locator.ServiceLocator;
import tn.esprit.auction.services.gestion.order.OrderServicesRemote;

public class GestionOrderDelegate {
	static OrderServicesRemote remote;
	private static final String jndi="auction-ejb/OrderServices!tn.esprit.auction.services.gestion.order.OrderServicesRemote"; 
	                                  
                                      
	private static OrderServicesRemote getProxy(){
		return (OrderServicesRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
	public  static Boolean doAddOrder(Order Order){
	return getProxy().addOrder(Order);
	
}
	
	public  static Boolean doUpdateOrder(Order Order){
		return getProxy().updateOrder(Order);
		
	}
	
	public  static Boolean doDeleteOrder(Order Order){
		return getProxy().deleteOrder(Order);
		
	}
	
	public  static Order doFindOrderById(Integer idOrder)
	{
		return getProxy().findOrderById(idOrder);
	}
	public  static List<Order> doFindAllOrders()
	{
		return getProxy().findAllOrders();
	}
	public  static List<Order> doFindAllOrdersByIdDeliveryMan(Integer idDeliveryMan)
	{
		return getProxy().findOrdersByIdDeliveryMan(idDeliveryMan);
	}
}

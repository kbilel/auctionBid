package tn.esprit.auction;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.auction.domain.Manager;
import tn.esprit.auction.domain.Order;
import tn.esprit.auction.services.gestion.order.OrderServicesRemote;

// ça marche pas !!

public class TestGestionOrder {
	static OrderServicesRemote remote;
	public static void doAddOrder(OrderServicesRemote remote){
Manager manager=new Manager();
		Order order=new Order();
		
		if(remote.addOrder(order)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...add");

	}
	public static void doUpdateOrder(OrderServicesRemote remote){
Manager manager=new Manager();
manager.setUserName("Le ManagerR");
		Order order=remote.findOrderById(2);
		order.setManager(manager);
		if(remote.updateOrder(order)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...");

	}
	public static void doDeleteOrder(OrderServicesRemote remote){

		Order order=remote.findOrderById(1);
		if (order ==null)
System.out.println("order null");
		if(remote.deleteOrder(order)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...delete");

	}
	public static void main(String[] args) {
		
		
		try {
			Context context=new InitialContext();
			remote=(OrderServicesRemote) context.lookup("auction-ejb/OrderServices!tn.esprit.auction.services.gestion.order.OrderServicesRemote");
				} catch (NamingException e) {
		System.out.println("erreur jndi ... ");
			e.printStackTrace();
		}
		
doAddOrder(remote);
		//doUpdateOrder(remote);
	//doDeleteOrder(remote);
	}
}

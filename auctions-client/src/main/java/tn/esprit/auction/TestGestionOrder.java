package tn.esprit.auction;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.auction.domain.DeliveryMan;
import tn.esprit.auction.domain.Manager;
import tn.esprit.auction.domain.Order;
import tn.esprit.auction.domain.OrderPK;
import tn.esprit.auction.domain.User;
import tn.esprit.auction.services.gestion.order.OrderServicesRemote;
import tn.esprit.auction.services.gestion.user.UserServicesRemote;

// ça marche pas !!

public class TestGestionOrder {
	static OrderServicesRemote remote;

	public static void doAddOrder(OrderServicesRemote remote) {
		
		OrderPK orderPk = new OrderPK(1, 3);
		Order order = new Order();

	order.setClient(3);
	order.setCashPayement(true);
	order.setOrderPK(orderPk);

	

		if (remote.addOrder(order)) {
			System.out.println("OK Order ajouté avec succés");
		} else
			System.out.println("Erreur ...add");

	}

	public static void doUpdateOrder(OrderServicesRemote remote) {
		Manager manager = new Manager();
		manager.setUserName("Le ManagerR");
		Order order = remote.findOrderById(2);
		order.setManager(manager);
		if (remote.updateOrder(order)) {
			System.out.println("OK");
		} else
			System.out.println("Erreur ...");

	}

	public static void doDeleteOrder(OrderServicesRemote remote) {

		Order order = remote.findOrderById(1);
		if (order == null)
			System.out.println("order null");
		if (remote.deleteOrder(order)) {
			System.out.println("OK");
		} else
			System.out.println("Erreur ...delete");

	}
	public static void doFindAllOrder(OrderServicesRemote remote){
		List<Order> orders=remote.findAllOrders();
		//Configuration configuration=new Configuration();

		if(orders!=null){
			
			System.out.println("OK find");
			
		
		}
		else
			System.out.println("Erreur  liste vide peut etre ...find Config");

	}

	public static void main(String[] args) {

		try {
			Context context = new InitialContext();
			remote = (OrderServicesRemote) context
					.lookup("auction-ejb/OrderServices!tn.esprit.auction.services.gestion.order.OrderServicesRemote");
		} catch (NamingException e) {
			System.out.println("erreur jndi ... ");
			e.printStackTrace();
		}

		//AddOrder(remote);
		// doUpdateOrder(remote);
		// doDeleteOrder(remote);
		doFindAllOrder(remote);
	}
}

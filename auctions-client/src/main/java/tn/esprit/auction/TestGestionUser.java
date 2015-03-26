package tn.esprit.auction;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;










import tn.esprit.auction.domain.Admin;
import tn.esprit.auction.domain.Client;
import tn.esprit.auction.domain.Configuration;
import tn.esprit.auction.domain.DeliveryMan;
import tn.esprit.auction.domain.Manager;
import tn.esprit.auction.domain.StockManager;
import tn.esprit.auction.domain.User;
import tn.esprit.auction.services.Configuration.ConfigurationServiceRemote;
import tn.esprit.auction.services.gestion.user.UserServicesRemote;



public class TestGestionUser {
	static UserServicesRemote remote;
	public static void doAddUser(UserServicesRemote remote){

		Manager user1=new Manager();
		user1.setUserName("alex");
		user1.setAdress("alex");
		user1.setEmail("alex");
		user1.setFullName("alex");
		user1.setPassword("alex");
		user1.setImageUrl("/tn/esprit/auction/gui/client/profilClient.png");
		
		Client user2=new Client();
		user2.setUserName("samir");
		user2.setAdress("samir");
		user2.setEmail("samir");
		user2.setFullName("samir");
		user2.setPassword("samir");
		user2.setImageUrl("imageAuction/2-2.jpg");
user2.setNumberTockens(20);		
		DeliveryMan user3=new DeliveryMan();
		user3.setUserName("kbilel");
		user3.setAdress("siliana - makthar");
		user3.setEmail("bilel.khaled@esprit.tn");
		user3.setFullName("bilel khaled");
		user3.setPassword("0000");
		user3.setImageUrl("/tn/esprit/auction/gui/client/profilClient.png");
		
		Admin user4=new Admin();
		user4.setUserName("admin");
		user4.setAdress("admin");
		user4.setEmail("admin@mail.fr");
		user4.setFullName("admin");
		user4.setPassword("admin");
		user4.setImageUrl("/tn/esprit/auction/gui/client/profilClient.png");
		
		StockManager user5=new StockManager();
		user5.setUserName("sab");
		user5.setAdress("sab");
		user5.setEmail("sab@mail.fr");
		user5.setFullName("sab");
		user5.setPassword("sab");
		user5.setImageUrl("/tn/esprit/auction/gui/client/profilClient.png");
		
		
		if(remote.addUser(user3)&remote.addUser(user1)&remote.addUser(user2)&remote.addUser(user4)&remote.addUser(user5)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...add");

	}
	public static void doUpdateUser(UserServicesRemote remote){

		User user=remote.findUserById(2);
		user.setUserName("ali");
		user.setFullName("ali");
		user.setPassword("ali");
		if(remote.updateUser(user)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...");

	}
	public static void doDeleteUser(UserServicesRemote remote){

		User user=remote.findUserById(6);
		User user2=remote.findUserById(5);
		
		if (user ==null)
System.out.println("user null");
		if(remote.deleteUser(user)&&remote.deleteUser(user2)){
			System.out.println("OK user has been deleted");
		}
		else
			System.out.println("Erreur ...delete");

	}
	
	public static void doAuthentifUser(UserServicesRemote remote){

User user= remote.authentificate("baya", "baya");
		
		
			
		
	if(user!=null)
	{
		System.out.println("OK authentification");
		
	}
	else
		System.out.println("ouupssss erreur authentification");

	}
	
	
	public static void doFindAllUser(UserServicesRemote remote){
		List<User> users=remote.findAllUsers();
		//Configuration configuration=new Configuration();

		if(users!=null){
			
			System.out.println("OK find");
			
		
		}
		else
			System.out.println("Erreur ...find Config");

	}
	
	public static void doFindUserByUsername(UserServicesRemote remote){
		User user=remote.findUserByUsername("samir");
		//Configuration configuration=new Configuration();

		if(user!=null){
			
			System.out.println("OK find");
			
		
		}
		else
			System.out.println("Erreur ...find Config");

	}
	
	
	
	public static void main(String[] args) {
		
		
		try {
			Context context=new InitialContext();
			remote=(UserServicesRemote) context.lookup("auction-ejb/UserServices!tn.esprit.auction.services.gestion.user.UserServicesRemote");
				} catch (NamingException e) {
		System.out.println("erreur jndi ... ");
			e.printStackTrace();
		}
	doAddUser(remote);	
//doFindAllUser(remote);
		//doUpdateUser(remote);
	//doDeleteUser(remote);
		//doFindUserByUsername(remote);
	
	
	}
}

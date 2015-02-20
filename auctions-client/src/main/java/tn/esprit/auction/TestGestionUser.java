package tn.esprit.auction;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;








import tn.esprit.auction.domain.Client;
import tn.esprit.auction.domain.Configuration;
import tn.esprit.auction.domain.DeliveryMan;
import tn.esprit.auction.domain.Manager;
import tn.esprit.auction.domain.User;
import tn.esprit.auction.services.Configuration.ConfigurationServiceRemote;
import tn.esprit.auction.services.gestion.user.UserServicesRemote;



public class TestGestionUser {
	static UserServicesRemote remote;
	public static void doAddUser(UserServicesRemote remote){

		Manager user1=new Manager();
		user1.setUserName("amiraaClien");
		user1.setAdress("amira");
		user1.setEmail("amira");
		user1.setFullName("amira");
		user1.setPassword("amira");
		
		Client user2=new Client();
		user2.setUserName("ali");
		user2.setAdress("ali");
		user2.setEmail("ali");
		user2.setFullName("ali");
		user2.setPassword("ali");
		
		DeliveryMan user3=new DeliveryMan();
		user3.setUserName("max");
		user3.setAdress("max");
		user3.setEmail("max");
		user3.setFullName("max");
		user3.setPassword("max");
		
		
		if(remote.addUser(user3)&remote.addUser(user1)&remote.addUser(user2)){
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
	
	public static void main(String[] args) {
		
		
		try {
			Context context=new InitialContext();
			remote=(UserServicesRemote) context.lookup("auction-ejb/UserServices!tn.esprit.auction.services.gestion.user.UserServicesRemote");
				} catch (NamingException e) {
		System.out.println("erreur jndi ... ");
			e.printStackTrace();
		}
	//doAddUser(remote);	
//doFindAllUser(remote);
		//doUpdateUser(remote);
	//doDeleteUser(remote);
	
	}
}

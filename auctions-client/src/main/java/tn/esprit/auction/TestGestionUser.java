package tn.esprit.auction;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;







import tn.esprit.auction.domain.Client;
import tn.esprit.auction.domain.Configuration;
import tn.esprit.auction.domain.Manager;
import tn.esprit.auction.domain.User;
import tn.esprit.auction.services.Configuration.ConfigurationServiceRemote;
import tn.esprit.auction.services.gestion.user.UserServicesRemote;



public class TestGestionUser {
	static UserServicesRemote remote;
	public static void doAddUser(UserServicesRemote remote){

		User user=new Manager();
		user.setUserName("achref");
		user.setAdress("achref");
		user.setEmail("achref");
		user.setFullName("achref");
		user.setPassword("achref");
		
		if(remote.addUser(user)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...add");

	}
	public static void doUpdateUser(UserServicesRemote remote){

		User user=remote.findUserById(2);
		user.setUserName("baya");
		user.setFullName("houda");
		user.setPassword("baya");
		if(remote.updateUser(user)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...");

	}
	public static void doDeleteUser(UserServicesRemote remote){

		User user=remote.findUserById(1);
		if (user ==null)
System.out.println("user null");
		if(remote.deleteUser(user)){
			System.out.println("OK");
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
	doAddUser(remote);	
//doFindAllUser(remote);
		//doUpdateUser(remote);
	//doDeleteUser(remote);
	}
}

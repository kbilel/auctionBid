package tn.esprit.auction.delegate;

import java.util.List;

import tn.esprit.auction.domain.User;
import tn.esprit.auction.locator.ServiceLocator;
import tn.esprit.auction.services.gestion.user.UserServicesRemote;

public class GestionUserDelegate {

	static UserServicesRemote remote;
	private static final String jndi="auction-ejb/UserServices!tn.esprit.auction.services.gestion.user.UserServicesRemote"; 

	private static UserServicesRemote getProxy(){
		return (UserServicesRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
	public  static Boolean doAddUser(User user){
	return getProxy().addUser(user);
	
}
	
	public  static Boolean doUpdateUser(User user){
		return getProxy().updateUser(user);
		
	}
	
	public  static Boolean doDeleteUser(User user){
		return getProxy().deleteUser(user);
		
	}
	
	public  static User doFindUserById(Integer idUser)
	{
		return getProxy().findUserById(idUser);
	}
	public  static List<User> doFindAllUsers()
	{
		return getProxy().findAllUsers();
	}
	
	
	public static User doAuthentificate(String login,String pwd){
		return getProxy().authentificate(login, pwd);
	}
}

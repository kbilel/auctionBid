package tn.esprit.auction.services.gestion.user;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.auction.services.gestion.user.GestionStaffRemote;
import tn.esprit.auction.domain.Manager;

public class TestGestionStaff {
static GestionStaffRemote remote;
public static void doAddManager(GestionStaffRemote remote) {
	Manager manager= new Manager();
	manager.setUserName("douha");
	if (remote.addManager(manager)){
		System.out.println("ok...");
	}
	else System.out.println("erreur");
}
	
public static void  main(String[] args) {
	try
	{ 
		Context context = new InitialContext();
	remote=(GestionStaffRemote) context.lookup("auction-ejb/GestionStaff!tn.esprit.auction.services.gestion.employee.staff.GestionStaffRemote");
	doAddManager(remote);	
	}
	catch (NamingException e){
		e.printStackTrace();
	}
}
}

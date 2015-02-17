package tn.esprit.auction;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.auction.domain.User;
import tn.esprit.auction.domain.Configuration;
import tn.esprit.auction.services.Configuration.ConfigurationServiceRemote;
import tn.esprit.auction.services.gestion.user.UserServicesRemote;

public class TestConfiguration {
	static ConfigurationServiceRemote remote;
	public static void doAddConfiguration(ConfigurationServiceRemote remote){

		Configuration configuration=new Configuration();
		configuration.setNbrTokenParInscription(10);
		configuration.setNbrTokenParInvitation(20);
		if(remote.addConfiguration(configuration)){
			System.out.println("OK add");
		}
		else
			System.out.println("Erreur ...add Config");

	}
	public static void doUpdateConfiguration(ConfigurationServiceRemote remote){

		Configuration configuration= remote.findConfigurationById(1);
		configuration.setNbrTokenParInvitation(15);
		if(remote.updateConfiguration(configuration))
		{
			System.out.println("okkkkkkkkkkk update ");
		}
		else
			System.out.println("ouuuupsssssssss update");

	}
	public static void doDeleteConfiguration(ConfigurationServiceRemote remote){

		Configuration configuration= remote.findConfigurationById(2);
		if(remote.deleteConfiguration(configuration))
		{
			System.out.println("okkkkkkkkkkk delete ");
		}
		else
			System.out.println("ouuuupsssssssss delete");

	}
	
	public static void doFindAllConfiguration(ConfigurationServiceRemote remote){
		List<Configuration> configurations=remote.findAllConfigurations();
		//Configuration configuration=new Configuration();

		if(configurations!=null){
			System.out.println("OK find");
		}
		else
			System.out.println("Erreur ...find Config");

	}
	
	public static void main(String[] args) {
		try {
			Context context=new InitialContext();
			remote=(ConfigurationServiceRemote) context.lookup("auction-ejb/ConfigurationService!tn.esprit.auction.services.Configuration.ConfigurationServiceRemote");
				} catch (NamingException e) {
		System.out.println("erreur jndi ... ");
			e.printStackTrace();
		}
		doAddConfiguration(remote);
		
		//doFindAllConfiguration(remote);
		//doUpdateUser(remote);
	//doDeleteUser(remote);

	}

}

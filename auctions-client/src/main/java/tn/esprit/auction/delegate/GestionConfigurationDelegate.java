package tn.esprit.auction.delegate;

import java.util.List;

import tn.esprit.auction.domain.Configuration;
import tn.esprit.auction.locator.ServiceLocator;
import tn.esprit.auction.services.Configuration.ConfigurationServiceRemote;
import tn.esprit.auction.services.gestion.user.UserServicesRemote;

public class GestionConfigurationDelegate {
	static ConfigurationServiceRemote remote;
	private static final String jndi="auction-ejb/ConfigurationService!tn.esprit.auction.services.Configuration.ConfigurationServiceRemote"; 

	private static ConfigurationServiceRemote getProxy(){
		return (ConfigurationServiceRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	public  static Boolean doAddConfiguration(Configuration configuration)
	{
		return getProxy().addConfiguration(configuration);
	}
	public  static Boolean doUpdateConfiguration(Configuration configuration)
	{
		return getProxy().updateConfiguration(configuration);
	}
	public  static Boolean doDeleteConfiguration(Configuration configuration)
	{
		return getProxy().deleteConfiguration(configuration);
	}
	public  static Configuration doFindConfigurationById(Integer idConfiguration)
	{
		return getProxy().findConfigurationById(idConfiguration);
	}
	public  static List<Configuration>doFindAllConfigurations()
	{
		return getProxy().findAllConfigurations();

	}

}

package tn.esprit.auction.services.Configuration;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.auction.domain.Configuration;
import tn.esprit.auction.domain.User;

@Remote
public interface ConfigurationServiceRemote {
	Boolean addConfiguration(Configuration configuration);
	Boolean updateConfiguration(Configuration configuration);
	Configuration findConfigurationById(Integer idConfiguration);
	Boolean deleteConfiguration(Configuration configuration);
	List<Configuration>findAllConfigurations();
}

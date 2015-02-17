package tn.esprit.auction.services.Configuration;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.auction.domain.Configuration;
import tn.esprit.auction.domain.User;

@Local
public interface ConfigurationServiceLocal {
	Boolean addConfiguration(Configuration configuration);
	Boolean updateConfiguration(Configuration configuration);
	Configuration findConfigurationById(Integer idConfiguration);
	Boolean deleteConfiguration(Configuration configuration);
	List<Configuration>findAllConfigurations();

}

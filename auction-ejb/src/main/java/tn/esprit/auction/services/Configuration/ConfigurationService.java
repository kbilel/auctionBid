package tn.esprit.auction.services.Configuration;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.auction.domain.Configuration;
import tn.esprit.auction.domain.User;

/**
 * Session Bean implementation class ConfigurationService
 */
@Stateless
public class ConfigurationService implements ConfigurationServiceRemote, ConfigurationServiceLocal {
	@PersistenceContext(unitName="auction-ejb")
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public ConfigurationService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addConfiguration(Configuration configuration) {
		try {
			entityManager.persist(configuration);
			System.out.println("ok ejb");
			
			return true;
		} catch (Exception e) {
			System.out.println("erreur ejb");
			return false;
			
		}
	}

	@Override
	public Boolean updateConfiguration(Configuration configuration) {
		try {
			entityManager.merge(configuration);
			
			return true;
		} catch (Exception e) {
			System.out.println("exception update user");
			return false;
		}
	}
	@Override
	public Boolean deleteConfiguration(Configuration configuration) {
try {
			
			
			entityManager.remove(entityManager.merge(configuration));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	
	@Override
	public List<Configuration> findAllConfigurations() {
		Query query=entityManager.createQuery("select c from Configuration c ");
		return query.getResultList();
	}

	@Override
	public Configuration findConfigurationById(Integer idConfiguration) {
		Configuration configuration=null;
		try {
			configuration=entityManager.find(Configuration.class, idConfiguration);
		
		} catch (Exception e) {
			
		}
		return configuration;
	}

	
	

}

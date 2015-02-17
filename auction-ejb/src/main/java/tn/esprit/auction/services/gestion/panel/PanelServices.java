package tn.esprit.auction.services.gestion.panel;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.auction.domain.Panel;

/**
 * Session Bean implementation class PanelServices
 */
@Stateless
@LocalBean
public class PanelServices implements PanelServicesRemote, PanelServicesLocal {


	@PersistenceContext(unitName="auction-ejb")
	EntityManager entityManager;
    public PanelServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addPanel(Panel panel) {
		try {
			entityManager.persist(panel);
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Boolean updatePanel(Panel panel) {
		try {
			entityManager.merge(panel);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deletePanel(Panel panel) {
		try {
			
			
			entityManager.remove(entityManager.merge(panel));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Panel findPanelById(Integer idPanel) {
		Panel panel=null;
		try {
			panel=entityManager.find(Panel.class, idPanel);
		
		} catch (Exception e) {
			
		}
		return panel;
	}

	@Override
	public List<Panel> findAllPanels() {
		Query query=entityManager.createQuery("select p from Panel p ");
		return query.getResultList();
	}

	
}

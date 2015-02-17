package tn.esprit.auction.services.gestion.payement;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.auction.domain.Payement;

/**
 * Session Bean implementation class PayementServices
 */
@Stateless
@LocalBean
public class PayementServices implements PayementServicesRemote, PayementServicesLocal {


	@PersistenceContext(unitName="auction-ejb")
	EntityManager entityManager;
    public PayementServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addPayement(Payement payement) {
		try {
			entityManager.persist(payement);
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Boolean updatePayement(Payement payement) {
		try {
			entityManager.merge(payement);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deletePayement(Payement payement) {
		try {
			
			
			entityManager.remove(entityManager.merge(payement));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Payement findPayementById(Integer idPayement) {
		Payement payement=null;
		try {
			payement=entityManager.find(Payement.class, idPayement);
		
		} catch (Exception e) {
			
		}
		return payement;
	}

	@Override
	public List<Payement> findAllPayements() {
		Query query=entityManager.createQuery("select p from Payement p ");
		return query.getResultList();
	}

	



}

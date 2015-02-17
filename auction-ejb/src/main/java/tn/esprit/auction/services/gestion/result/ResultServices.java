package tn.esprit.auction.services.gestion.result;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.auction.domain.Result;

/**
 * Session Bean implementation class ResultServices
 */
@Stateless
@LocalBean
public class ResultServices implements ResultServicesRemote, ResultServicesLocal {


	@PersistenceContext(unitName="auction-ejb")
	EntityManager entityManager;
    public ResultServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addResult(Result result) {
		try {
			entityManager.persist(result);
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Boolean updateResult(Result result) {
		try {
			entityManager.merge(result);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteResult(Result result) {
		try {
			
			
			entityManager.remove(entityManager.merge(result));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Result findResultById(Integer idResult) {
		Result result=null;
		try {
			result=entityManager.find(Result.class, idResult);
		
		} catch (Exception e) {
			
		}
		return result;
	}

	@Override
	public List<Result> findAllResults() {
		Query query=entityManager.createQuery("select r from Result r ");
		return query.getResultList();
	}

	

}

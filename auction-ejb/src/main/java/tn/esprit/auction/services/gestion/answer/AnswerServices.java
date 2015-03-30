package tn.esprit.auction.services.gestion.answer;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.auction.domain.Answer;

/**
 * Session Bean implementation class AnswerServices
 */
@Stateless
@LocalBean
public class AnswerServices implements AnswerServicesRemote, AnswerServicesLocal {


	@PersistenceContext(unitName="auction-ejb")
	EntityManager entityManager;
    public AnswerServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addAnswer(Answer answer) {
		try {
			entityManager.persist(answer);
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Boolean updateAnswer(Answer answer) {
		try {
			entityManager.merge(answer);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteAnswer(Answer answer) {
		try {
			
			
			entityManager.remove(entityManager.merge(answer));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Answer findAnswerById(Integer idAnswer) {
		Answer answer=null;
		try {
			answer=entityManager.find(Answer.class, idAnswer);
		
		} catch (Exception e) {
			
		}
		return answer;
	}

	@Override
	public List<Answer> findAllAnswers() {
		Query query=entityManager.createQuery("select a from Answer a ");
		return query.getResultList();
	}

}

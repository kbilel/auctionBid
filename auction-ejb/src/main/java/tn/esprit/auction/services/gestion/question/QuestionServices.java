package tn.esprit.auction.services.gestion.question;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.auction.domain.Question;

/**
 * Session Bean implementation class QuestionServices
 */
@Stateless
@LocalBean
public class QuestionServices implements QuestionServicesRemote, QuestionServicesLocal {

	@PersistenceContext(unitName="auction-ejb")
	EntityManager entityManager;
    public QuestionServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addQuestion(Question question) {
		try {
			entityManager.persist(question);
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Boolean updateQuestion(Question question) {
		try {
			entityManager.merge(question);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteQuestion(Question question) {
		try {
			
			
			entityManager.remove(entityManager.merge(question));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Question findQuestionById(Integer idQuestion) {
		Question question=null;
		try {
			question=entityManager.find(Question.class, idQuestion);
		
		} catch (Exception e) {
			
		}
		return question;
	}

	@Override
	public List<Question> findAllQuestions() {
		Query query=entityManager.createQuery("select q from Question q ");
		return query.getResultList();
	}

	


}

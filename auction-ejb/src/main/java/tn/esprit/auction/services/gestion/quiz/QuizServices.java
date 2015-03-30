package tn.esprit.auction.services.gestion.quiz;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.auction.domain.Quiz;

/**
 * Session Bean implementation class QuizServices
 */
@Stateless
@LocalBean
public class QuizServices implements QuizServicesRemote, QuizServicesLocal {


	@PersistenceContext(unitName="auction-ejb")
	EntityManager entityManager;
    public QuizServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addQuiz(Quiz quiz) {
		try {
			entityManager.persist(quiz);
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Boolean updateQuiz(Quiz quiz) {
		try {
			entityManager.merge(quiz);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteQuiz(Quiz quiz) {
		try {
			
			
			entityManager.remove(entityManager.merge(quiz));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Quiz findQuizById(Integer idQuiz) {
		Quiz quiz=null;
		try {
			quiz=entityManager.find(Quiz.class, idQuiz);
		
		} catch (Exception e) {
			
		}
		return quiz;
	}

	@Override
	public List<Quiz> findAllQuizs() {
		Query query=entityManager.createQuery("select q from Quiz q ");
		return query.getResultList();
	}

	

}

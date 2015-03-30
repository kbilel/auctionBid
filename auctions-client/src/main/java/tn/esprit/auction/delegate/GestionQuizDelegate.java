package tn.esprit.auction.delegate;

import java.util.List;

import tn.esprit.auction.domain.Quiz;
import tn.esprit.auction.locator.ServiceLocator;
import tn.esprit.auction.services.gestion.quiz.QuizServicesRemote;
import tn.esprit.auction.services.gestion.user.UserServicesRemote;

public class GestionQuizDelegate {
	static QuizServicesRemote remote;
	private static final String jndi="auction-ejb/QuizServices!tn.esprit.auction.services.gestion.quiz.QuizServicesRemote"; 
	private static QuizServicesRemote getProxy(){
		return (QuizServicesRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
	Boolean addQuiz(Quiz quiz )
	{
		return getProxy().addQuiz(quiz);

	}
	Boolean updateQuiz(Quiz quiz)
	{
		return getProxy().updateQuiz(quiz);

	}
	Boolean deleteQuiz(Quiz quiz)
	{
		return getProxy().deleteQuiz(quiz);

	}
	Quiz findQuizById(Integer idQuiz)
	{
		return getProxy().findQuizById(idQuiz);

	}
	List<Quiz>findAllQuizs()
	{
		return getProxy().findAllQuizs();
		
	}
	

}

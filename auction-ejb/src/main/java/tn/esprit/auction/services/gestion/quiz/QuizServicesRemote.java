package tn.esprit.auction.services.gestion.quiz;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.auction.domain.Quiz;

@Remote
public interface QuizServicesRemote {
	Boolean addQuiz(Quiz quiz );
	Boolean updateQuiz(Quiz quiz);
	Boolean deleteQuiz(Quiz quiz);
	Quiz findQuizById(Integer idQuiz);
	List<Quiz>findAllQuizs();
	
}

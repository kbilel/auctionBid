package tn.esprit.auction.services.gestion.quiz;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.auction.domain.Quiz;

@Local
public interface QuizServicesLocal {
	Boolean addQuiz(Quiz quiz );
	Boolean updateQuiz(Quiz quiz);
	Boolean deleteQuiz(Quiz quiz);
	Quiz findQuizById(Integer idQuiz);
	List<Quiz>findAllQuizs();
	
}

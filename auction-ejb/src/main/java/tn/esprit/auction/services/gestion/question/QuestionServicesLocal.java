package tn.esprit.auction.services.gestion.question;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.auction.domain.Question;

@Local
public interface QuestionServicesLocal {
	Boolean addQuestion(Question question );
	Boolean updateQuestion(Question question);
	Boolean deleteQuestion(Question question);
	Question findQuestionById(Integer idQuestion);
	List<Question>findAllQuestions();
	
}

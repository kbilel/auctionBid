package tn.esprit.auction.services.gestion.question;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.auction.domain.Question;

@Remote
public interface QuestionServicesRemote {
	Boolean addQuestion(Question question );
	Boolean updateQuestion(Question question);
	Boolean deleteQuestion(Question question);
	Question findQuestionById(Integer idQuestion);
	List<Question>findAllQuestions();
	
}

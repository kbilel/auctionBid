package tn.esprit.auction.services.gestion.answer;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.auction.domain.Answer;

@Local
public interface AnswerServicesLocal {
	Boolean addAnswer(Answer answer );
	Boolean updateAnswer(Answer answer);
	Boolean deleteAnswer(Answer answer);
	Answer findAnswerById(Integer idAnswer);
	List<Answer>findAllAnswers();
}

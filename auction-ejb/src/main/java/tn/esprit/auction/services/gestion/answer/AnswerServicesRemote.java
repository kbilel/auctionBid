package tn.esprit.auction.services.gestion.answer;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.auction.domain.Answer;

@Remote
public interface AnswerServicesRemote {
	Boolean addAnswer(Answer answer );
	Boolean updateAnswer(Answer answer);
	Boolean deleteAnswer(Answer answer);
	Answer findAnswerById(Integer idAnswer);
	List<Answer>findAllAnswers();
}

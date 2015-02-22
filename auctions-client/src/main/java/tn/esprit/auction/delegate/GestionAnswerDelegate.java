package tn.esprit.auction.delegate;

import java.util.List;

import tn.esprit.auction.domain.Answer;
import tn.esprit.auction.locator.ServiceLocator;
import tn.esprit.auction.services.gestion.answer.AnswerServicesRemote;
import tn.esprit.auction.services.gestion.question.QuestionServicesRemote;
import tn.esprit.auction.services.gestion.user.UserServicesRemote;

public class GestionAnswerDelegate {

	static AnswerServicesRemote remote;
	private static final String jndi="auction-ejb/AnswerServices!tn.esprit.auction.services.gestion.answer.AnswerServicesRemote"; 
	private static AnswerServicesRemote getProxy(){
		return (AnswerServicesRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	public  static Boolean doAddAnswer(Answer answer )
	{
		return getProxy().addAnswer(answer);
	}
	public  static Boolean doUpdateAnswer(Answer answer)
	{
		return getProxy().updateAnswer(answer);
		
	}
	public  static Boolean doDeleteAnswer(Answer answer)
	{
		return getProxy().deleteAnswer(answer);

	}
	public  static Answer doFindAnswerById(Integer idAnswer)
	{
		return getProxy().findAnswerById(idAnswer);

	}
	public  static List<Answer>doFindAllAnswers()
	{
		return getProxy().findAllAnswers();
	}
	
}

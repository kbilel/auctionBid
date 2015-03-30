package tn.esprit.auction.delegate;

import java.util.List;

import tn.esprit.auction.domain.Question;
import tn.esprit.auction.locator.ServiceLocator;
import tn.esprit.auction.services.gestion.question.QuestionServicesRemote;
import tn.esprit.auction.services.gestion.user.UserServicesRemote;

public class GestionQuestionDelegate {
	static QuestionServicesRemote remote;
	private static final String jndi="auction-ejb/QuestionServices!tn.esprit.auction.services.gestion.question.QuestionServicesRemote"; 
	private static QuestionServicesRemote getProxy(){
		return (QuestionServicesRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	
		// TODO Auto-generated constructor stub
	public  static Boolean doAddQuestion(Question question )
		{
			return getProxy().addQuestion(question);
		}
	public  static	Boolean doUpdateQuestion(Question question)
		{
			return getProxy().updateQuestion(question);
			
		}
	public  static	Boolean doDeleteQuestion(Question question)
		{
			return getProxy().deleteQuestion(question);
		}
	public  static	Question doFindQuestionById(Integer idQuestion)
		{
			return getProxy().findQuestionById(idQuestion);
		}
	public  static	List<Question>doFindAllQuestions()
		{
			return getProxy().findAllQuestions();
		}
		
	

}

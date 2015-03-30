package tn.esprit.auction;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;












import tn.esprit.auction.domain.Client;
import tn.esprit.auction.domain.Configuration;
import tn.esprit.auction.domain.DeliveryMan;
import tn.esprit.auction.domain.Manager;
import tn.esprit.auction.domain.Question;
import tn.esprit.auction.domain.Question;
import tn.esprit.auction.services.Configuration.ConfigurationServiceRemote;
import tn.esprit.auction.services.gestion.question.QuestionServicesRemote;



public class TestGestionQuestion{
	static QuestionServicesRemote remote;
	public static void doAddQuestion(QuestionServicesRemote remote){

		Question question = new Question();
		question.setText("ouuuuuuuh");
		
		if(remote.addQuestion(question)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...add");

	}
	public static void doUpdateQuestion(QuestionServicesRemote remote){

		Question question=remote.findQuestionById(1);
		question.setText("aaaaaaaaaaaaaaaaaaah");
		if(remote.updateQuestion(question))
		{
			System.out.println();
		}
		

	}
	public static void doDeleteQuestion(QuestionServicesRemote remote){

		Question Question=remote.findQuestionById(1);
		
		if (Question ==null)
System.out.println("Question null");
		if(remote.deleteQuestion(Question)){
			System.out.println("OK Question has been deleted");
		}
		else
			System.out.println("Erreur ...delete");

	}
	
	
	
	
	public static void doFindAllQuestion(QuestionServicesRemote remote){
		List<Question> Questions=remote.findAllQuestions();
		//Configuration configuration=new Configuration();

		if(Questions!=null){
			
			System.out.println("OK find");
			
		
		}
		else
			System.out.println("Erreur ...find Config");

	}
	
	public static void main(String[] args) {
		
		
		try {
			Context context=new InitialContext();
			remote=(QuestionServicesRemote) context.lookup("auction-ejb/QuestionServices!tn.esprit.auction.services.gestion.question.QuestionServicesRemote");
				} catch (NamingException e) {
		System.out.println("erreur jndi ... ");
			e.printStackTrace();
		}
	doDeleteQuestion(remote);
//doFindAllQuestion(remote);
		//doUpdateQuestion(remote);
	//doDeleteQuestion(remote);
	
	}
}

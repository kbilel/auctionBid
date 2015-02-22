package tn.esprit.auction;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;











import tn.esprit.auction.domain.Client;
import tn.esprit.auction.domain.Configuration;
import tn.esprit.auction.domain.DeliveryMan;
import tn.esprit.auction.domain.Manager;
import tn.esprit.auction.domain.Quiz;
import tn.esprit.auction.domain.Quiz;
import tn.esprit.auction.services.Configuration.ConfigurationServiceRemote;
import tn.esprit.auction.services.gestion.quiz.QuizServicesRemote;



public class TestGestionQuiz{
	static QuizServicesRemote remote;
	public static void doAddQuiz(QuizServicesRemote remote){

		Quiz Quiz = new Quiz();
		
		if(remote.addQuiz(Quiz)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...add");

	}
	public static void doUpdateQuiz(QuizServicesRemote remote){

		Quiz Quiz=remote.findQuizById(1);
		

	}
	public static void doDeleteQuiz(QuizServicesRemote remote){

		Quiz Quiz=remote.findQuizById(1);
		
		if (Quiz ==null)
System.out.println("Quiz null");
		if(remote.deleteQuiz(Quiz)){
			System.out.println("OK Quiz has been deleted");
		}
		else
			System.out.println("Erreur ...delete");

	}
	
	
	
	
	public static void doFindAllQuiz(QuizServicesRemote remote){
		List<Quiz> Quizs=remote.findAllQuizs();
		//Configuration configuration=new Configuration();

		if(Quizs!=null){
			
			System.out.println("OK find");
			
		
		}
		else
			System.out.println("Erreur ...find Config");

	}
	
	public static void main(String[] args) {
		
		
		try {
			Context context=new InitialContext();
			remote=(QuizServicesRemote) context.lookup("auction-ejb/QuizServices!tn.esprit.auction.services.gestion.quiz.QuizServicesRemote");
				} catch (NamingException e) {
		System.out.println("erreur jndi ... ");
			e.printStackTrace();
		}
	//doAddQuiz(remote);	
//doFindAllQuiz(remote);
		//doUpdateQuiz(remote);
	doDeleteQuiz(remote);
	
	}
}

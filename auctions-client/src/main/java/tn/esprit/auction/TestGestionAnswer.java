package tn.esprit.auction;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.auction.domain.Answer;
import tn.esprit.auction.services.gestion.answer.AnswerServicesRemote;

public class TestGestionAnswer {
	static AnswerServicesRemote remote;
	public static void doAddAnswer(AnswerServicesRemote remote){

		Answer answer=new Answer();
		answer.setText("foulen");
		if(remote.addAnswer(answer)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...add");

	}
	public static void doUpdateAnswer(AnswerServicesRemote remote){

		Answer answer=remote.findAnswerById(1);
		answer.setText("foulen1");
		if(remote.updateAnswer(answer)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...");

	}
	public static void doDeleteAnswer(AnswerServicesRemote remote){

		Answer answer=remote.findAnswerById(1);
		
		if(remote.deleteAnswer(answer)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...");

	}
	public static void main(String[] args) {
		
		
		try {
			Context context=new InitialContext();
			remote=(AnswerServicesRemote) context.lookup("auction-ejb/AnswerServices!tn.esprit.auction.services.gestion.answer.AnswerServicesRemote");
				} catch (NamingException e) {
		System.out.println("erreur jndi ... ");
			e.printStackTrace();
		}
		
//doAddAnswer(remote);
		//doUpdateAnswer(remote);
	doDeleteAnswer(remote);
	}
}

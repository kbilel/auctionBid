package tn.esprit.auction.domain;

import java.io.Serializable;
import java.lang.Float;

import javax.persistence.*;

import tn.esprit.auction.domain.ResultPK;

/**
 * Entity implementation class for Entity: Result
 *
 */
@Entity
@Table(name="t_result")
public class Result implements Serializable {

	
	private Float score;
	private ResultPK resultPK;
	private static final long serialVersionUID = 1L;
	private Client client;
	private Quiz quiz;

	public Result() {
		super();
	}   
	public Float getScore() {
		return this.score;
	}

	public void setScore(Float score) {
		this.score = score;
	} 
	@EmbeddedId
	public ResultPK getResultPK() {
		return this.resultPK;
	}

	public void setResultPK(ResultPK resultPK) {
		this.resultPK = resultPK;
	}
	@ManyToOne
	@JoinColumn(name="id_client",referencedColumnName="id",insertable=false,updatable=false)
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@ManyToOne
	@JoinColumn(name="id_quiz",referencedColumnName="id",insertable=false,updatable=false)
	public Quiz getQuiz() {
		return quiz;
	}
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	public Result(Float score,  Client client, Quiz quiz) {
		super();
		this.score = score;
		this.resultPK = new ResultPK(quiz.getId(),client.getId());
		this.client = client;
		this.quiz = quiz;
	}
	
	
   
}

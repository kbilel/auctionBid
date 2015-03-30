package tn.esprit.auction.domain;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Answer
 *
 */
@Entity
@Table(name="t_answer")

public class Answer implements Serializable {

	
	private Integer id;
	private String text;
	private Boolean correct;
	private static final long serialVersionUID = 1L;
	private Question question;

	
	public Answer() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getText() {
		return this.text;
	}
	//hello world

	public void setText(String text) {
		this.text = text;
	}   
	public Boolean getCorrect() {
		return this.correct;
	}

	public void setCorrect(Boolean correct) {
		this.correct = correct;
	}
	@ManyToOne
	@JoinColumn(name="question")
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
   
}

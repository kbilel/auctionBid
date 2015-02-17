package tn.esprit.auction.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Question
 *
 */
@Entity
@Table(name="t_question")

public class Question implements Serializable {

	
	private Integer id;
	private String text;
	private static final long serialVersionUID = 1L;
	private List<Answer> answers;
	//private List<Quiz> quizs;

	public Question() {
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

	public void setText(String text) {
		this.text = text;
	}
	@OneToMany(mappedBy="question")
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	/*@ManyToMany(mappedBy="questions")
	public List<Quiz> getQuizs() {
		return quizs;
	}
	public void setQuizs(List<Quiz> quizs) {
		this.quizs = quizs;
	}  */
   
}

package tn.esprit.auction.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Quiz
 *
 */
@Entity
@Table(name="t_quiz")

public class Quiz implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	private static final long serialVersionUID = 1L;
	//private List<Question> questions;

	public Quiz() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	/*@ManyToMany
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questionss) {
		this.questions = questionss;
	}  
   */
}

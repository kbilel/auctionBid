package tn.esprit.auction.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ResultPK implements Serializable{
	private Integer idQuiz;
	private Integer idClient;
	

	public ResultPK() {
		// TODO Auto-generated constructor stub
	}

	@Column(name="id_quiz")
	public Integer getIdQuiz() {
		return idQuiz;
	}


	public void setIdQuiz(Integer idQuiz) {
		this.idQuiz = idQuiz;
	}

	@Column(name="id_client")
	public Integer getIdClient() {
		return idClient;
	}


	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idClient == null) ? 0 : idClient.hashCode());
		result = prime * result + ((idQuiz == null) ? 0 : idQuiz.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultPK other = (ResultPK) obj;
		if (idClient == null) {
			if (other.idClient != null)
				return false;
		} else if (!idClient.equals(other.idClient))
			return false;
		if (idQuiz == null) {
			if (other.idQuiz != null)
				return false;
		} else if (!idQuiz.equals(other.idQuiz))
			return false;
		return true;
	}

	public ResultPK(Integer idQuiz, Integer idClient) {
		super();
		this.idQuiz = idQuiz;
		this.idClient = idClient;
	}
	

}

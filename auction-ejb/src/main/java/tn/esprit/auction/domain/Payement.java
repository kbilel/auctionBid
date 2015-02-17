package tn.esprit.auction.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Payement
 *
 */
@Entity
@Table(name="t_payement")

public class Payement implements Serializable {

	
	private Integer id;
	private Integer amount;
	private Date date;
	private static final long serialVersionUID = 1L;
	private Client client;

	
	public Payement() {
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
	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	@ManyToOne
	@JoinColumn(name="client")
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
   
}

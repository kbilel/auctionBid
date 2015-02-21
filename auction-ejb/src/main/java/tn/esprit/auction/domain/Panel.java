package tn.esprit.auction.domain;

import java.io.Serializable;
import java.lang.Float;

import javax.persistence.*;

import tn.esprit.auction.domain.PanelPK;

/**
 * Entity implementation class for Entity: Panel
 *
 */
@Entity
@Table(name="t_panel")

public class Panel implements Serializable {

	
	private Float totalPrice;
	private PanelPK panelPK;
	private static final long serialVersionUID = 1L;
	private Client client;

	public Panel() {
		super();
	}    
	public Float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}  
	@EmbeddedId
	public PanelPK getPanelPK() {
		return this.panelPK;
	}

	public void setPanelPK(PanelPK panelPK) {
		this.panelPK = panelPK;
	}
	@ManyToOne
	@JoinColumn(name="id_client",referencedColumnName="id",insertable=false,updatable=false)
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Panel(Float totalPrice, Client client) {
		super();
		this.totalPrice = totalPrice;
		this.panelPK = new PanelPK(client.getId());
		this.client = client;
	}
	
	
   
}

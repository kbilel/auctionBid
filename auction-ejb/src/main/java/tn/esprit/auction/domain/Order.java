package tn.esprit.auction.domain;

import java.io.Serializable;
import java.lang.Boolean;
import java.util.Date;

import javax.persistence.*;

import tn.esprit.auction.domain.Client;
import tn.esprit.auction.domain.OrderPK;
import tn.esprit.auction.domain.Product;

/**
 * Entity implementation class for Entity: Order
 *
 */
@Entity
@Table(name="t_order")

public class Order implements Serializable {

	
	private OrderPK orderPK;
	private Client client;
	private Product produit;
	private Date dateLimit;
	private Boolean cashPayement;
	private Manager manager;
	private DeliveryMan deliveryMan;
	private static final long serialVersionUID = 1L;

	public Order() {
		super();
	} 
	@EmbeddedId
	public OrderPK getOrderPK() {
		return this.orderPK;
	}

	public void setOrderPK(OrderPK orderPK) {
		this.orderPK = orderPK;
	}  
	@Column(name="id_client")
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}   
	@Column(name="id_produit")
	public Product getProduit() {
		return this.produit;
	}

	public void setProduit(Product produit) {
		this.produit = produit;
	} 
	@Column(name="date_limit")
	public Date getDateLimit() {
		return this.dateLimit;
	}
	
	public void setDateLimit(Date dateLimit) {
		this.dateLimit = dateLimit;
	}   
	@Column(name="cash_payement")
	public Boolean getCashPayement() {
		return this.cashPayement;
	}

	public void setCashPayement(Boolean cashPayement) {
		this.cashPayement = cashPayement;
	}
	@ManyToOne
	@JoinColumn(name="id_manager",referencedColumnName="id",insertable=false,updatable=false)

	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	@ManyToOne
	@JoinColumn(name="id_delivery_man",referencedColumnName="id",insertable=false,updatable=false)

	public DeliveryMan getDeliveryMan() {
		return deliveryMan;
	}
	public void setDeliveryMan(DeliveryMan deliveryMan) {
		this.deliveryMan = deliveryMan;
	}
	public Order(Client client, Product produit, Date dateLimit,
			Boolean cashPayement, Manager manager, DeliveryMan deliveryMan) {
		super();
		this.client = client;
		this.produit = produit;
		this.dateLimit = dateLimit;
		this.cashPayement = cashPayement;
		this.manager = manager;
		this.deliveryMan = deliveryMan;
		this.orderPK=new OrderPK(manager.getId(), deliveryMan.getId());
	}
   
}

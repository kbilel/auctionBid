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

	 private Date dateLimit;
	 private Boolean cashPayement;
     private String adressClient ;
	 private String state="Not Delivred";
	 private Integer idDeliveryMan;

	private Client client;
	private Product product;
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

	public Date getDateLimit() {
		return dateLimit;
	}

	public void setDateLimit(Date dateLimit) {
		this.dateLimit = dateLimit;
	}

	public Boolean getCashPayement() {
		return cashPayement;
	}

	public void setCashPayement(Boolean cashPayement) {
		this.cashPayement = cashPayement;
	}

	public String getAdressClient() {
		return adressClient;
	}

	public void setAdressClient(String adressClient) {
		this.adressClient = adressClient;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
	@JoinColumn(name="id_product",referencedColumnName="id",insertable=false,updatable=false)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order( Date dateLimit, Boolean cashPayement,
			String adressClient, String state, Client client, Product product ,Integer idDeliveryMan) {
		super();
		this.orderPK = new OrderPK(client.getId(),product.getId());
		this.dateLimit = dateLimit;
		this.cashPayement = cashPayement;
		this.adressClient = adressClient;
		this.state = state;
		this.client = client;
		this.product = product;
		this.idDeliveryMan=idDeliveryMan;
	}

	public Integer getIdDeliveryMan() {
		return idDeliveryMan;
	}

	public void setIdDeliveryMan(Integer idDeliveryMan) {
		this.idDeliveryMan = idDeliveryMan;
	}  
   
}

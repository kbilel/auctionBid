package tn.esprit.auction.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import tn.esprit.auction.domain.MessagePK;

/**
 * Entity implementation class for Entity: Message
 *
 */
@Entity
@Table(name="t_message")

public class Message implements Serializable {

	
	private String text;
	private MessagePK messagePK;
	private static final long serialVersionUID = 1L;
	private Client client;
	private Auction auction;

	public Message() {
		super();
	}   
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}   
	@EmbeddedId
	public MessagePK getMessagePK() {
		return this.messagePK;
	}

	public void setMessagePK(MessagePK messagePK) {
		this.messagePK = messagePK;
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
	@JoinColumn(name="id_auction",referencedColumnName="id",insertable=false,updatable=false)
	public Auction getAuction() {
		return auction;
	}
	public void setAuction(Auction auction) {
		this.auction = auction;
	}
	public Message(String text, Client client, Auction auction) {
		super();
		this.text = text;
		this.client = client;
		this.auction = auction;
		this.messagePK=new MessagePK(client.getId(),auction.getId());
	}
   
	
	
}

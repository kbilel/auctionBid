package tn.esprit.auction.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
 
@Embeddable
public class MessagePK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idClient ;
	private Integer idAuction ;
	

	public MessagePK() {
		// TODO Auto-generated constructor stub
	}

	@Column(name="id_client")
	public Integer getIdClient() {
		return idClient;
	}


	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	@Column(name="id_auction")
	public Integer getIdAuction() {
		return idAuction;
	}


	public void setIdAuction(Integer idAuction) {
		this.idAuction = idAuction;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idAuction == null) ? 0 : idAuction.hashCode());
		result = prime * result
				+ ((idClient == null) ? 0 : idClient.hashCode());
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
		MessagePK other = (MessagePK) obj;
		if (idAuction == null) {
			if (other.idAuction != null)
				return false;
		} else if (!idAuction.equals(other.idAuction))
			return false;
		if (idClient == null) {
			if (other.idClient != null)
				return false;
		} else if (!idClient.equals(other.idClient))
			return false;
		return true;
	}

	public MessagePK(Integer idClient, Integer idAuction) {
		super();
		this.idClient = idClient;
		this.idAuction = idAuction;
	}
	
	

}

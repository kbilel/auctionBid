package tn.esprit.auction.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class BidPK implements Serializable {
private Integer idClient;
private Integer idYankeeAuction;

public BidPK() {
	// TODO Auto-generated constructor stub
}
@Column(name="id_client")
public Integer getIdClient() {
	return idClient;
}
public void setIdClient(Integer idClient) {
	this.idClient = idClient;
}
@Column(name="id_yankee_auction")
public Integer getIdYankeeAuction() {
	return idYankeeAuction;
}
public void setIdYankeeAuction(Integer idYankeeAuction) {
	this.idYankeeAuction = idYankeeAuction;
}
//test

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	//hey
	result = prime * result + ((idClient == null) ? 0 : idClient.hashCode());
	result = prime * result
			+ ((idYankeeAuction == null) ? 0 : idYankeeAuction.hashCode());
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
	BidPK other = (BidPK) obj;
	if (idClient == null) {
		if (other.idClient != null)
			return false;
	} else if (!idClient.equals(other.idClient))
		return false;
	if (idYankeeAuction == null) {
		if (other.idYankeeAuction != null)
			return false;
	} else if (!idYankeeAuction.equals(other.idYankeeAuction))
		return false;
	return true;
}
public BidPK(Integer idClient, Integer idYankeeAuction) {
	super();
	this.idClient = idClient;
	this.idYankeeAuction = idYankeeAuction;
}
}

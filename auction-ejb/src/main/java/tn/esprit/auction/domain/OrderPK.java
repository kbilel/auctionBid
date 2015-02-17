package tn.esprit.auction.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class OrderPK implements Serializable {
	private Integer idManager;
	private Integer idDeliveryMan;
	public OrderPK() {
		// TODO Auto-generated constructor stub
	}
	@Column(name="id_manager")
	public Integer getIdManager() {
		return idManager;
	}
	public void setIdManager(Integer idManager) {
		this.idManager = idManager;
	}
	@Column(name="id_delivery_man")
	public Integer getIdDeliveryMan() {
		return idDeliveryMan;
	}
	public void setIdDeliveryMan(Integer idDeliveryMan) {
		this.idDeliveryMan = idDeliveryMan;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idDeliveryMan == null) ? 0 : idDeliveryMan.hashCode());
		result = prime * result
				+ ((idManager == null) ? 0 : idManager.hashCode());
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
		OrderPK other = (OrderPK) obj;
		if (idDeliveryMan == null) {
			if (other.idDeliveryMan != null)
				return false;
		} else if (!idDeliveryMan.equals(other.idDeliveryMan))
			return false;
		if (idManager == null) {
			if (other.idManager != null)
				return false;
		} else if (!idManager.equals(other.idManager))
			return false;
		return true;
	}
	public OrderPK(Integer idManager, Integer idDeliveryMan) {
		super();
		this.idManager = idManager;
		this.idDeliveryMan = idDeliveryMan;
	}
	
}

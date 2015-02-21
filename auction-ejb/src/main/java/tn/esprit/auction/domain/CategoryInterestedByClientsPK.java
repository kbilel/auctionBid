package tn.esprit.auction.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CategoryInterestedByClientsPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idClient ;
	private Integer idCategory ;
	
	public CategoryInterestedByClientsPK() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column(name="id_client")
	public Integer getIdClient() {
		return idClient;
	}
	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}
	@Column(name="id_category")
	public Integer getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idCategory == null) ? 0 : idCategory.hashCode());
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
		CategoryInterestedByClientsPK other = (CategoryInterestedByClientsPK) obj;
		if (idCategory == null) {
			if (other.idCategory != null)
				return false;
		} else if (!idCategory.equals(other.idCategory))
			return false;
		if (idClient == null) {
			if (other.idClient != null)
				return false;
		} else if (!idClient.equals(other.idClient))
			return false;
		return true;
	}
	public CategoryInterestedByClientsPK(Integer idClient, Integer idCategory) {
		super();
		this.idClient = idClient;
		this.idCategory = idCategory;
	}
	
}

package tn.esprit.auction.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_category_interested_by_clients")
public class CategoryInterestedByClients  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private CategoryInterestedByClientsPK categoryInterestedByClientsPK;
	private Client client;
	private Category category;
	
	public CategoryInterestedByClients() {
		super();
		// TODO Auto-generated constructor stub
	}
	@EmbeddedId
	public CategoryInterestedByClientsPK getCategoryInterestedByClientsPK() {
		return categoryInterestedByClientsPK;
	}
	public void setCategoryInterestedByClientsPK(
			CategoryInterestedByClientsPK categoryInterestedByClientsPK) {
		this.categoryInterestedByClientsPK = categoryInterestedByClientsPK;
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
	@JoinColumn(name="id_category",referencedColumnName="id",insertable=false,updatable=false)
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public CategoryInterestedByClients(Client client, Category category) {
		super();
		this.categoryInterestedByClientsPK = new CategoryInterestedByClientsPK(client.getId(),category.getId());
		this.client = client;
		this.category = category;
	}
	
}

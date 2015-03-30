package tn.esprit.auction.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_category")

public class Category implements Serializable {

	private String name;
	private Integer id ;
	private static final long serialVersionUID = 1L;
	private List<CategoryInterestedByClients>categoryInterestedByClients;

	public Category() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@OneToMany (mappedBy="category")
	public List<CategoryInterestedByClients> getCategoryInterestedByClients() {
		return categoryInterestedByClients;
	}

	public void setCategoryInterestedByClients(
			List<CategoryInterestedByClients> categoryInterestedByClients) {
		this.categoryInterestedByClients = categoryInterestedByClients;
	}
   
}

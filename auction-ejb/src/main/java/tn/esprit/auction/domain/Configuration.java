package tn.esprit.auction.domain;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Configuration
 *
 */
@Entity
@Table(name="t_configuration")

public class Configuration  implements Serializable {

	private Integer id;
	private Integer nbrTokenParInvitation;
	private Integer nbrTokenParInscription;
	private static final long serialVersionUID = 1L;

	public Configuration() {
		super();
	}
	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column (name="nbr_token_par_invitation")
	public Integer getNbrTokenParInvitation() {
		return nbrTokenParInvitation;
	}

	public void setNbrTokenParInvitation(Integer nbrTokenParInvitation) {
		this.nbrTokenParInvitation = nbrTokenParInvitation;
	}

	@Column (name="nbr_token_par_inscription")
	public Integer getNbrTokenParInscription() {
		return nbrTokenParInscription;
	}

	public void setNbrTokenParInscription(Integer nbrTokenParInscription) {
		this.nbrTokenParInscription = nbrTokenParInscription;
	}
   
}

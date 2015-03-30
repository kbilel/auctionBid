package tn.esprit.auction.domain;

import java.io.Serializable;
import javax.persistence.*;
import tn.esprit.auction.domain.User;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity
@Table(name="t_admin")

public class Admin extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}
   
}

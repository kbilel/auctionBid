package tn.esprit.auction.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import tn.esprit.auction.domain.User;

/**
 * Entity implementation class for Entity: Manager
 *
 */
@Entity
@Table(name="t_manager")

public class Manager extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	

	public Manager() {
		super();
	}

   
}

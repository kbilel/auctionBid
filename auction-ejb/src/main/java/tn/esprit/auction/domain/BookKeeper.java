package tn.esprit.auction.domain;

import java.io.Serializable;
import javax.persistence.*;
import tn.esprit.auction.domain.User;

/**
 * Entity implementation class for Entity: BookKeeper
 *
 */
@Entity
@Table(name="t_book_keeper")

public class BookKeeper extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public BookKeeper() {
		super();
	}
   
}

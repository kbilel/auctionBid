package tn.esprit.auction.domain;

import java.io.Serializable;
import javax.persistence.*;
import tn.esprit.auction.domain.User;

/**
 * Entity implementation class for Entity: StockManager
 *
 */
@Entity
@Table(name="t_stock_manager")

public class StockManager extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public StockManager() {
		super();
	}
   
}

package tn.esprit.auction.domain;

import java.util.List;
import java.io.Serializable;

import javax.persistence.*;

import tn.esprit.auction.domain.User;

/**
 * Entity implementation class for Entity: DeliveryMan
 *
 */
@Entity
@Table(name="t_delivery_man")

public class DeliveryMan extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	public DeliveryMan() {
		super();
	}

   
}

package tn.esprit.auction.services.gestion.payement;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.auction.domain.Payement;

@Local
public interface PayementServicesLocal {
	Boolean addPayement(Payement payement );
	Boolean updatePayement(Payement payement);
	Boolean deletePayement(Payement payement);
	Payement findPayementById(Integer idPayement);
	List<Payement>findAllPayements();
	
}

package tn.esprit.auction.services.gestion.payement;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.auction.domain.Payement;

@Remote
public interface PayementServicesRemote {
	Boolean addPayement(Payement payement );
	Boolean updatePayement(Payement payement);
	Boolean deletePayement(Payement payement);
	Payement findPayementById(Integer idPayement);
	List<Payement>findAllPayements();
	
}

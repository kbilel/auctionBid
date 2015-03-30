package tn.esprit.auction.services.gestion.result;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.auction.domain.Result;
import tn.esprit.auction.domain.User;

@Remote
public interface ResultServicesRemote {
	Boolean addResult(Result result );
	Boolean updateResult(Result result);
	Boolean deleteResult(Result result);
	Result findResultById(Integer idResult);
	List<Result>findAllResults();
	
}

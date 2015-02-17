package tn.esprit.auction.services.gestion.result;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.auction.domain.Result;

@Local
public interface ResultServicesLocal {
	Boolean addResult(Result result );
	Boolean updateResult(Result result);
	Boolean deleteResult(Result result);
	Result findResultById(Integer idResult);
	List<Result>findAllResults();
	
}

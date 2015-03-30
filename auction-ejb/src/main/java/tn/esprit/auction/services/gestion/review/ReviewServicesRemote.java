package tn.esprit.auction.services.gestion.review;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.auction.domain.Review;

@Remote
public interface ReviewServicesRemote {
	Boolean addReview(Review review );
	Boolean updateReview(Review review);
	Boolean deleteReview(Review review);
	Review findReviewById(Integer idReview);
	List<Review>findAllReviews();
	
}

package tn.esprit.auction.services.gestion.review;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.auction.domain.Review;

@Local
public interface ReviewServicesLocal {
	Boolean addReview(Review review );
	Boolean updateReview(Review review);
	Boolean deleteReview(Review review);
	Review findReviewById(Integer idReview);
	List<Review>findAllReviews();
	
}

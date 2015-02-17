package tn.esprit.auction.services.gestion.review;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.auction.domain.Review;

/**
 * Session Bean implementation class ReviewServices
 */
@Stateless

public class ReviewServices implements ReviewServicesRemote, ReviewServicesLocal {
	@PersistenceContext(unitName="auction-ejb")
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public ReviewServices() {
        // TODO Auto-generated constructor stub
    }
	
	
	
	
	
	@Override
	public Boolean addReview(Review review) {
		try {
			entityManager.persist(review);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public Boolean updateReview(Review review) {
		try {
			entityManager.merge(review);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public Boolean deleteReview(Review review) {
try {
			
			
			entityManager.remove(entityManager.merge(review));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public Review findReviewById(Integer idReview) {

		Review review=null;
		try {
			review=entityManager.find(Review.class, idReview);
		
		} catch (Exception e) {
			
		}
		return review;
	}
	@Override
	public List<Review> findAllReviews() {
		Query query=entityManager.createQuery("select r from User r ");
		return query.getResultList();
	}
	
}

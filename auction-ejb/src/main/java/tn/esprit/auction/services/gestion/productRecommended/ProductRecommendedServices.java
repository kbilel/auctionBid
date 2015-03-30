package tn.esprit.auction.services.gestion.productRecommended;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.auction.domain.ProductRecommended;

/**
 * Session Bean implementation class ProductRecommendedServices
 */
@Stateless
@LocalBean
public class ProductRecommendedServices implements ProductRecommendedServicesRemote, ProductRecommendedServicesLocal {

	@PersistenceContext(unitName="auction-ejb")
	EntityManager entityManager;
    public ProductRecommendedServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addProductRecommended(ProductRecommended productRecommended) {
		try {
			entityManager.persist(productRecommended);
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Boolean updateProductRecommended(ProductRecommended productRecommended) {
		try {
			entityManager.merge(productRecommended);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteProductRecommended(ProductRecommended productRecommended) {
		try {
			
			
			entityManager.remove(entityManager.merge(productRecommended));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ProductRecommended findProductRecommendedById(Integer idProductRecommended) {
		ProductRecommended productRecommended=null;
		try {
			productRecommended=entityManager.find(ProductRecommended.class, idProductRecommended);
		
		} catch (Exception e) {
			
		}
		return productRecommended;
	}

	@Override
	public List<ProductRecommended> findAllProductRecommendeds() {
		Query query=entityManager.createQuery("select p from ProductRecommended p ");
		return query.getResultList();
	}

	


}

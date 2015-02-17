package tn.esprit.auction.services.gestion.product;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.auction.domain.Product;

/**
 * Session Bean implementation class ProductServices
 */
@Stateless
@LocalBean
public class ProductServices implements ProductServicesRemote, ProductServicesLocal {

	@PersistenceContext(unitName="auction-ejb")
	EntityManager entityManager;
    public ProductServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addProduct(Product product) {
		try {
			entityManager.persist(product);
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Boolean updateProduct(Product product) {
		try {
			entityManager.merge(product);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteProduct(Product product) {
		try {
			
			
			entityManager.remove(entityManager.merge(product));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Product findProductById(Integer idProduct) {
		Product product=null;
		try {
			product=entityManager.find(Product.class, idProduct);
		
		} catch (Exception e) {
			
		}
		return product;
	}

	@Override
	public List<Product> findAllProducts() {
		Query query=entityManager.createQuery("select p from Product p ");
		return query.getResultList();
	}

	

}

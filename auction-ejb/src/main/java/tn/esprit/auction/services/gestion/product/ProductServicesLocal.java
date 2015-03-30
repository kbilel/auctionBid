package tn.esprit.auction.services.gestion.product;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.auction.domain.Product;

@Local
public interface ProductServicesLocal {
	Boolean addProduct(Product product );
	Boolean updateProduct(Product product);
	Boolean deleteProduct(Product product);
	Product findProductById(Integer idProduct);
	List<Product>findAllProducts();
	List<Product>findAllProductsByCategory(String category);
	
}

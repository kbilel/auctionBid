package tn.esprit.auction.services.gestion.productRecommended;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.auction.domain.ProductRecommended;

@Remote
public interface ProductRecommendedServicesRemote {
	Boolean addProductRecommended(ProductRecommended productRecommended );
	Boolean updateProductRecommended(ProductRecommended productRecommended);
	Boolean deleteProductRecommended(ProductRecommended productRecommended);
	ProductRecommended findProductRecommendedById(Integer idProductRecommended);
	List<ProductRecommended>findAllProductRecommendeds();
	
}

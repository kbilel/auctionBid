package tn.esprit.auction;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.auction.domain.Product;
import tn.esprit.auction.services.gestion.product.ProductServicesRemote;

public class TestGestionProduct {
	static ProductServicesRemote remote;
	public static void doAddProduct(ProductServicesRemote remote){

		Product product=new Product();
		product.setName("iphone");
		if(remote.addProduct(product)){
			System.out.println("Product added");
		}
		else
			System.out.println("Erreur ...add");

	}
	public static void doUpdateProduct(ProductServicesRemote remote){

		Product product=remote.findProductById(1);
		product.setName("iphone5");
		if(remote.updateProduct(product)){
			System.out.println("updated");
		}
		else
			System.out.println("Erreur ...update");

	}
	public static void doDeleteProduct(ProductServicesRemote remote){

		Product product=remote.findProductById(1);
		if (product ==null)
System.out.println("product null");
		if(remote.deleteProduct(product)){
			System.out.println("deleted");
		}
		else
			System.out.println("Erreur ...delete");

	}
	public static void main(String[] args) {
		
		
		try {
			Context context=new InitialContext();
			remote=(ProductServicesRemote) context.lookup("auction-ejb/ProductServices!tn.esprit.auction.services.gestion.product.ProductServicesRemote");
				} catch (NamingException e) {
		System.out.println("erreur jndi ... ");
			e.printStackTrace();
		}
		
doAddProduct(remote);
		//doUpdateProduct(remote);
	//doDeleteProduct(remote);
	}
	

}

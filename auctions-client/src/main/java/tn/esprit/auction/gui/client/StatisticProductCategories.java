package tn.esprit.auction.gui.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import tn.esprit.auction.delegate.GestionProductDelegate;
import tn.esprit.auction.domain.Product;

import java.awt.Color;

public class StatisticProductCategories extends JPanel {
	
	DefaultPieDataset dataset = null;
    JFreeChart graphe = null;
   ChartPanel cp = null;

	/**
	 * Create the panel.
	 */
	public StatisticProductCategories() {
		setBackground(new Color(255, 250, 240));
	setLayout(null);
	setBounds(0, 21, 1142, 791);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 240));
		panel.setBounds(0, 21, 1142, 791);
		add(panel);
		
		
		/********Stat*******/
		 List<Product> products=new ArrayList<Product>();
		 products=GestionProductDelegate.doFindAllProducts();
		 List<String> categories=new ArrayList<String>();
		 List<Integer> nbrProd=new ArrayList<Integer>();
		 Map<String, Integer> mapCategorie = new HashMap<String, Integer>();
		 mapCategorie.put(products.get(0).getCategory(),1);

		
		
		 Integer compteur=0;
		 for (Product product : products) {
			 if(compteur>0)
			 { //System.out.println("nbr Categories ="+ mapCategorie.get("Home"));
				
				 if(mapCategorie.containsKey(product.getCategory()))
				{
					mapCategorie.put(product.getCategory(),mapCategorie.get(product.getCategory())+1);
					
				}
				else
					mapCategorie.put(product.getCategory(),1);
			 }
			 compteur++;
			
		}
		
		
		 dataset = new DefaultPieDataset();
		 
     
		 Set listKeys=mapCategorie.keySet();  // Obtenir la liste des clés
		Iterator iterateur=listKeys.iterator();
		// Parcourir les clés et afficher les entrées de chaque clé;
		
		while(iterateur.hasNext())
		{
			
			String key= (String) iterateur.next();
			// System.out.println("nbr Categories ="+ key);
			
			 dataset.setValue(key,(Integer) mapCategorie.get(key));
		}            
         

     
     
    
    
     
     graphe = ChartFactory.createPieChart3D("Pie Chart Products/Categories", dataset,true, true, true);
     panel.setLayout(null);
     
     cp = new ChartPanel(graphe);
     cp.setBounds(28, 21, 1092, 708);
     cp.setLayout(null);
     JLabel lblNewLabel = new JLabel("");
     lblNewLabel.setIcon(new ImageIcon(StatisticAuctionCategories.class.getResource("/tn/esprit/auction/gui/client/statistic.png")));
     lblNewLabel.setBounds(-15, 570, 200, 150);
     cp.add(lblNewLabel);
     panel.add(cp);
     //tabbedPane.addTab("New tab", null, cp, null);
		/********Stat Product*******/

	}

}

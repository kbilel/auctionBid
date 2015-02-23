package tn.esprit.auction.gui.client;

import java.io.IOException;
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
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import tn.esprit.auction.delegate.GestionProductDelegate;
import tn.esprit.auction.domain.Product;

import java.awt.Color;

public class StatisticProductCategoriesBar extends JPanel {
	 

	public StatisticProductCategoriesBar() {
		setBackground(new Color(255, 250, 240));
		setLayout(null);
		setBounds(0, 21, 1800, 750);
		 JPanel panel = new JPanel();
		 panel.setBackground(new Color(255, 250, 240));
		 panel.setBounds(0, 21, 1800, 750);
		 add(panel);
		 //panel.setLayout(null);
		
		final CategoryDataset dataset ;
	     final JFreeChart graphe ;
	     final ChartPanel chartPanel;
		try {
			
			dataset = createDataset();
			graphe = createChart(dataset);
			panel.setLayout(null);
			chartPanel = new ChartPanel(graphe);
			 chartPanel.setBounds(28, 21, 1092, 708);
			 chartPanel.setPreferredSize(new java.awt.Dimension(400, 400));
			 JLabel lblNewLabel = new JLabel("");
		      lblNewLabel.setIcon(new ImageIcon(StatisticAuctionCategories.class.getResource("/tn/esprit/auction/gui/client/statistic.png")));
		      lblNewLabel.setBounds(-25, 613, 181, 110);
		      chartPanel.add(lblNewLabel);
			 panel.add(chartPanel);
			 chartPanel.setLayout(null);
			 if(panel!=null)
			 System.out.println("eni linna :D");
			 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 

	}
	public CategoryDataset createDataset() throws IOException {
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
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
				 Set listKeys=mapCategorie.keySet();  // Obtenir la liste des clés
					Iterator iterateur=listKeys.iterator();
					// Parcourir les clés et afficher les entrées de chaque clé;
					
					while(iterateur.hasNext())
					{
						
						String key= (String) iterateur.next();
						// System.out.println("nbr Categories ="+ key);
						
						 dataset.setValue(mapCategorie.get(key), key,"");
					}            

					return dataset;
		    }
	
	public JFreeChart createChart(CategoryDataset dataset) {
        final JFreeChart chart = ChartFactory.createBarChart3D(
                "  Product Categories ", // charttitle
                " ", // domainaxis label
                " quantity ", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // includelegend
                true, // tooltips
                true// urls
                );

        final CategoryPlot plot = chart.getCategoryPlot();
        final CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 2.0));
        final CategoryItemRenderer renderer = plot.getRenderer();
        //  renderer.setItemLabelsVisible(true);
        return chart;
    }

}

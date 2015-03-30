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
import org.jfree.data.general.DefaultPieDataset;

import tn.esprit.auction.delegate.GestionAuctionDelegate;
import tn.esprit.auction.delegate.GestionProductDelegate;
import tn.esprit.auction.domain.Auction;
import tn.esprit.auction.domain.DutchAuction;
import tn.esprit.auction.domain.EnglishAuction;
import tn.esprit.auction.domain.NegociatedAuction;
import tn.esprit.auction.domain.Product;
import tn.esprit.auction.domain.YankeeAuction;

import java.awt.Color;

public class StatisticAuctionYearBar extends JPanel {
	 

	public StatisticAuctionYearBar() {
		final ChartPanel chartPanel;
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
	     
		try {
			
			dataset = createDataset();
			graphe = createChart(dataset);
			panel.setLayout(null);
			chartPanel = new ChartPanel(graphe);
			 chartPanel.setBounds(28, 21, 1092, 708);
			 chartPanel.setPreferredSize(new java.awt.Dimension(400, 400));
			 chartPanel.setLayout(null);
			 JLabel lblNewLabel = new JLabel("");
		      lblNewLabel.setIcon(new ImageIcon(StatisticAuctionCategories.class.getResource("/tn/esprit/auction/gui/client/statistic.png")));
		      lblNewLabel.setBounds(-14, 558, 200, 150);
		      chartPanel.add(lblNewLabel);
			 
			 panel.add(chartPanel);
			 if(panel!=null)
			 System.out.println("eni linna :D");
			 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 

	}
	public CategoryDataset createDataset() throws IOException {
		// 0. Création d'un diagramme.
		        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		        List<Auction>auctions=new ArrayList<Auction>();
				 auctions=GestionAuctionDelegate.doFindAllAuctions();
				 List<String> years=new ArrayList<String>();
				 List<Integer> nbrAuction=new ArrayList<Integer>();
				 Map<String, Integer> mapYear = new HashMap<String, Integer>();
				 if(auctions.size()>0)
				 { String year=""+(auctions.get(0).getAuctionStartingDate().getYear()+1900);

				 mapYear.put(year,1);
				
				 Integer compteur=0;
				 for (Auction auction:auctions) {
					 if(compteur>0)
					 { //System.out.println("nbr Categories ="+ mapCategorie.get("Home"));
						year=""+(auction.getAuctionStartingDate().getYear()+1900);
						 if(mapYear.containsKey(year))
						{
							mapYear.put(year,mapYear.get(year)+1);
							
						}
						else
							mapYear.put(year,1);
					 }
					 compteur++;
					
				}}
				
				
				
				 
		    
				 Set listKeys=mapYear.keySet();  // Obtenir la liste des clés
				Iterator iterateur=listKeys.iterator();
				// Parcourir les clés et afficher les entrées de chaque clé;
				
				while(iterateur.hasNext())
				{
					
					String key= (String) iterateur.next();
					// System.out.println("nbr Categories ="+ key);
					
					 dataset.setValue((Integer) mapYear.get(key),key,"");
				} 
				
				
				return dataset;
		    }
	
	public JFreeChart createChart(CategoryDataset dataset) {
        final JFreeChart chart = ChartFactory.createBarChart3D(
                "  Auction Categories ", // charttitle
                " ", // domainaxis label
                " auction's number ", // range axis label
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

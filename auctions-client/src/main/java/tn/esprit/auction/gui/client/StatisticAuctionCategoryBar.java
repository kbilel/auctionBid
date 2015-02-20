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

public class StatisticAuctionCategoryBar extends JPanel {
	 

	public StatisticAuctionCategoryBar() {
		setBackground(new Color(255, 250, 240));
		setLayout(null);
		setBounds(0, 21, 1142, 791);
		 JPanel panel = new JPanel();
		 panel.setBackground(new Color(255, 250, 240));
		 panel.setBounds(10, 21, 1132, 791);
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
			 chartPanel.setBounds(40, 26, 1092, 708);
			 chartPanel.setPreferredSize(new java.awt.Dimension(400, 400));
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
		//Valeurs statiques
		        List<Auction> auctions=new ArrayList<Auction>();
				 auctions=GestionAuctionDelegate.doFindAllAuctions();
				 Integer englishAuction=0;
				 Integer yankeeAuction=0;
				 Integer dutchAuction=0;
				 Integer negocietedAuction=0;
				 Integer auction5=0;
				 
		      for (Auction auction : auctions) {
		          if (auction instanceof EnglishAuction) {
		              englishAuction++;
		              
		          } else if (auction instanceof YankeeAuction) {
		          	yankeeAuction++;
		             
		          } else if (auction instanceof DutchAuction) {
		          	dutchAuction++;
		          } else if (auction instanceof NegociatedAuction) {
		          	negocietedAuction++;
		          } 
		          //else if (auction instanceof YankeeAuction) {
		            //  auction5++;
		         // System.out.println(england);}
		            
		          

		      }
		     
		      dataset.setValue(englishAuction,"English Auction","" );
		      dataset.setValue(yankeeAuction,"Dutch Auction","" );
		      dataset.setValue(dutchAuction,"Yankee Auction", "");
		      dataset.setValue(negocietedAuction,"Negocieted Auction","");
		      dataset.setValue(auction5,"Other","" );   

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

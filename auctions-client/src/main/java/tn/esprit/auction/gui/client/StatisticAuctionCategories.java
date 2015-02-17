package tn.esprit.auction.gui.client;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import tn.esprit.auction.delegate.GestionAuctionDelegate;
import tn.esprit.auction.domain.Auction;
import tn.esprit.auction.domain.DutchAuction;
import tn.esprit.auction.domain.EnglishAuction;
import tn.esprit.auction.domain.NegociatedAuction;
import tn.esprit.auction.domain.YankeeAuction;

public class StatisticAuctionCategories extends JPanel {
	ProfilClient profileClient=new ProfilClient();
	DefaultPieDataset dataset = null;
    JFreeChart graphe = null;
   ChartPanel cp = null;
	public StatisticAuctionCategories() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 430, 278);
		add(panel);
		/********Stat*******/
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
      dataset = new DefaultPieDataset();
      dataset.setValue("English Auction", englishAuction);
      dataset.setValue("Dutch Auction", yankeeAuction);
      dataset.setValue("Yankee Auction", dutchAuction);
      dataset.setValue("England",negocietedAuction);
      dataset.setValue("Other", auction5);
      graphe = ChartFactory.createPieChart3D("Pie Chart Country", dataset,true, true, true);
      
      cp = new ChartPanel(graphe);
      panel.add(cp);
      //tabbedPane.addTab("New tab", null, cp, null);
		/********Stat*******/

	}
}

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

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class StatisticAuctionCategories extends JPanel {
	
	DefaultPieDataset dataset = null;
    JFreeChart graphe = null;
   ChartPanel cp = null;
	public StatisticAuctionCategories() {
		setBackground(new Color(250, 250, 210));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 240));
		panel.setBounds(0, 21, 1800, 750);
		add(panel, new Integer(0), 0);
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
      dataset.setValue("Negocieted Auction",negocietedAuction);
      dataset.setValue("Other", auction5);
      graphe = ChartFactory.createPieChart3D("Pie Chart Auctions/Categories", dataset,true, true, true);
      panel.setLayout(null);
      
      cp = new ChartPanel(graphe);
      cp.setBackground(new Color(253, 245, 230));
      cp.setBounds(28, 21, 1092, 708);
      panel.add(cp);
      cp.setLayout(null);
      
      JLabel lblNewLabel = new JLabel("");
      lblNewLabel.setIcon(new ImageIcon(StatisticAuctionCategories.class.getResource("/tn/esprit/auction/gui/client/statistic.png")));
      lblNewLabel.setBounds(-22, 564, 181, 144);
      cp.add(lblNewLabel);
      //tabbedPane.addTab("New tab", null, cp, null);
		/********Stat*******/

	}
}

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

import tn.esprit.auction.delegate.GestionAuctionDelegate;
import tn.esprit.auction.domain.Auction;
import tn.esprit.auction.domain.DutchAuction;
import tn.esprit.auction.domain.EnglishAuction;
import tn.esprit.auction.domain.NegociatedAuction;
import tn.esprit.auction.domain.YankeeAuction;

import java.awt.Color;

public class StatisticAuctionYear extends JPanel {
	
	DefaultPieDataset dataset = null;
    JFreeChart graphe = null;
   ChartPanel cp = null;
   
	public StatisticAuctionYear() {
		setBackground(new Color(255, 250, 240));
		setLayout(null);
		setBounds(0, 21, 1800, 750);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 240));
		panel.setBounds(0, 21, 1800, 750);
		add(panel);
		
		/********Stat*******/
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
		
		
		 dataset = new DefaultPieDataset();
		 
    
		 Set listKeys=mapYear.keySet();  // Obtenir la liste des clés
		Iterator iterateur=listKeys.iterator();
		// Parcourir les clés et afficher les entrées de chaque clé;
		
		while(iterateur.hasNext())
		{
			
			String key= (String) iterateur.next();
			// System.out.println("nbr Categories ="+ key);
			
			 dataset.setValue(key,(Integer) mapYear.get(key));
		}            
    
    graphe = ChartFactory.createPieChart3D("Pie Chart Auction/Year", dataset,true, true, true);
    panel.setLayout(null);
    cp = new ChartPanel(graphe);
    cp.setBounds(28, 21, 1092, 708);
    cp.setLayout(null);
    JLabel lblNewLabel = new JLabel("");
    lblNewLabel.setIcon(new ImageIcon(StatisticAuctionCategories.class.getResource("/tn/esprit/auction/gui/client/statistic.png")));
    lblNewLabel.setBounds(-11, 558, 200, 150);
    cp.add(lblNewLabel);
    panel.add(cp);
    //tabbedPane.addTab("New tab", null, cp, null);
		/********Stat Product*******/
	}
}

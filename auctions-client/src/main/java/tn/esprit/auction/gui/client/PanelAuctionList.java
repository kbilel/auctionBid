package tn.esprit.auction.gui.client;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import tn.esprit.auction.delegate.GestionAuctionDelegate;
import tn.esprit.auction.domain.Auction;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import java.util.Date;

public class PanelAuctionList extends JPanel {
	private JTable table;
	private List<Auction>auctions;

	/**
	 * Create the panel.
	 */
	public PanelAuctionList() {
		auctions= new ArrayList<Auction>();
		auctions=GestionAuctionDelegate.doFindAllAuctions();
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 810, 222);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<Auction, List<Auction>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, auctions, table);
		//
		BeanProperty<Auction, Date> auctionBeanProperty = BeanProperty.create("auctionStartingDate");
		jTableBinding.addColumnBinding(auctionBeanProperty).setColumnName("Starting Date").setEditable(false);
		//
		BeanProperty<Auction, String> auctionBeanProperty_1 = BeanProperty.create("class.simpleName");
		jTableBinding.addColumnBinding(auctionBeanProperty_1).setColumnName("Type").setEditable(false);
		//
		BeanProperty<Auction, Date> auctionBeanProperty_2 = BeanProperty.create("auctionStartingDate");
		jTableBinding.addColumnBinding(auctionBeanProperty_2).setColumnName("End Date").setEditable(false);
		//
		BeanProperty<Auction, Integer> auctionBeanProperty_3 = BeanProperty.create("auctionStartingPrice");
		jTableBinding.addColumnBinding(auctionBeanProperty_3).setColumnName("Starting Price").setEditable(false);
		//
		BeanProperty<Auction, String> auctionBeanProperty_4 = BeanProperty.create("product.category");
		jTableBinding.addColumnBinding(auctionBeanProperty_4).setColumnName("Category").setEditable(false);
		//
		BeanProperty<Auction, String> auctionBeanProperty_5 = BeanProperty.create("product.name");
		jTableBinding.addColumnBinding(auctionBeanProperty_5).setColumnName("Name").setEditable(false);
		//
		jTableBinding.bind();
	}
}

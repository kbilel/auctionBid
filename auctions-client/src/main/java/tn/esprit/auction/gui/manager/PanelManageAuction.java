package tn.esprit.auction.gui.manager;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JMenuBar;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;

import tn.esprit.auction.delegate.GestionAuctionDelegate;
import tn.esprit.auction.domain.EnglishAuction;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import tn.esprit.auction.domain.Client;


import java.util.Date;

import org.jdesktop.beansbinding.ObjectProperty;

public class PanelManageAuction extends JPanel {
	private JTable table;
	List<EnglishAuction> englishAuctions;

	/**
	 * Create the panel.
	 */
	public PanelManageAuction() {
		englishAuctions=new ArrayList<EnglishAuction>();
		englishAuctions=GestionAuctionDelegate.doFindAllEnglishAuctions();
		setBorder(new TitledBorder(null, "Manage Auctions", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PanelManageAuction.class.getResource("/tn/esprit/auction/gui/manager/bid.png")));
		label.setBounds(27, 0, 120, 116);
		add(label);
		
		JLabel label_1 = new JLabel("Manager  Space");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 40));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(246, 36, 659, 74);
		add(label_1);
		
		JLabel label_4 = new JLabel("English Auctions Table :");
		label_4.setForeground(new Color(0, 0, 139));
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_4.setBounds(230, 194, 249, 41);
		add(label_4);
		
		JLabel label_5 = new JLabel("Click here to convert a Product to an Auction !");
		label_5.setForeground(Color.GREEN);
		label_5.setBounds(200, 357, 454, 14);
		add(label_5);
		
		JLabel label_6 = new JLabel("Select an auction to update and then click the button !");
		label_6.setForeground(new Color(255, 140, 0));
		label_6.setBounds(200, 393, 454, 14);
		add(label_6);
		
		JButton button_1 = new JButton("Add new Auction");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConvertProductToAuction frame = new ConvertProductToAuction();
				frame.setVisible(true);
			}
		});
		button_1.setBounds(0, 357, 190, 23);
		add(button_1);
		
		JButton button_2 = new JButton("Update selected Auction");
		button_2.setBounds(0, 389, 190, 23);
		add(button_2);
		
		JButton button_3 = new JButton("Delete selected Auction");
		button_3.setBounds(0, 423, 190, 23);
		add(button_3);
		
		JLabel label_7 = new JLabel("Select an auction to delete and then click the button !");
		label_7.setForeground(Color.RED);
		label_7.setBounds(200, 427, 454, 14);
		add(label_7);
		
		table = new JTable();
		table.setBounds(37, 253, 730, 41);
		add(table);
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<EnglishAuction, List<EnglishAuction>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, englishAuctions, table);
		//
		BeanProperty<EnglishAuction, Integer> englishAuctionBeanProperty = BeanProperty.create("auctionStartingPrice");
		jTableBinding.addColumnBinding(englishAuctionBeanProperty).setColumnName("Starting Price").setEditable(false);
		//
		BeanProperty<EnglishAuction, Integer> englishAuctionBeanProperty_1 = BeanProperty.create("currentBidValue");
		jTableBinding.addColumnBinding(englishAuctionBeanProperty_1).setColumnName("Current Bid Value").setEditable(false);
		//
		BeanProperty<EnglishAuction, Client> englishAuctionBeanProperty_2 = BeanProperty.create("currentWinner");
		jTableBinding.addColumnBinding(englishAuctionBeanProperty_2).setColumnName("Current Winner").setEditable(false);
		//
		BeanProperty<EnglishAuction, String> englishAuctionBeanProperty_3 = BeanProperty.create("product.name");
		jTableBinding.addColumnBinding(englishAuctionBeanProperty_3).setColumnName("Produit Name").setEditable(false);
		//
		BeanProperty<EnglishAuction, Date> englishAuctionBeanProperty_4 = BeanProperty.create("auctionEndDate");
		jTableBinding.addColumnBinding(englishAuctionBeanProperty_4).setColumnName("End Time").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}

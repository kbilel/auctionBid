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

import tn.esprit.auction.domain.Auction;
import tn.esprit.auction.domain.Client;



import tn.esprit.auction.domain.Product;

import java.util.Date;

import org.jdesktop.beansbinding.ObjectProperty;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

public class PanelManageAuction extends JPanel {
	List<Auction> auctions;
	private JTable table;
	 static Auction auctionSelected;
	 private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelManageAuction() {
		auctions=new ArrayList<Auction>();
		auctions=GestionAuctionDelegate.doFindAllAuctions();
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
		
		JLabel lblAuctionsTable = new JLabel("Auction's Table :");
		lblAuctionsTable.setForeground(new Color(0, 0, 139));
		lblAuctionsTable.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAuctionsTable.setBounds(27, 142, 249, 41);
		add(lblAuctionsTable);
		
		JLabel label_5 = new JLabel("Click here to convert a Product to an Auction !");
		label_5.setForeground(Color.GREEN);
		label_5.setBounds(266, 357, 454, 14);
		add(label_5);
		
		JLabel label_6 = new JLabel("Select an auction to update and then click the button !");
		label_6.setForeground(new Color(255, 140, 0));
		label_6.setBounds(266, 393, 454, 14);
		add(label_6);
		
		JButton button_1 = new JButton("Add new Auction");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConvertProductToAuction frame = new ConvertProductToAuction();
				frame.setVisible(true);
			}
		});
		button_1.setBounds(66, 357, 190, 23);
		add(button_1);
		
		JButton button_2 = new JButton("Update selected Auction");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(auctionSelected!=null){
					UpdateAuction updateAuction=new UpdateAuction();
					updateAuction.setVisible(true);
				}else {
					ErreurSelection erreurSelection=new ErreurSelection();
				    erreurSelection.setVisible(true);
				}
			}
		});
		button_2.setBounds(66, 389, 190, 23);
		add(button_2);
		
		JButton button_3 = new JButton("Delete selected Auction");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(auctionSelected!=null){
				ConfirmDelete confirmDelete=new ConfirmDelete();
				confirmDelete.setVisible(true);
			}else {
				ErreurSelection erreurSelection=new ErreurSelection();
			    erreurSelection.setVisible(true);
			}}
		});
		button_3.setBounds(66, 423, 190, 23);
		add(button_3);
		
		JLabel label_7 = new JLabel("Select an auction to delete and then click the button !");
		label_7.setForeground(Color.RED);
		label_7.setBounds(266, 427, 454, 14);
		add(label_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 187, 756, 159);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 auctionSelected = new Auction();
						auctionSelected=	auctions.get(table.getSelectedRow());
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnRefreshTable = new JButton("Find Auction By Product name");
		btnRefreshTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product product=new Product();
				product.setName(textField.getText());
			auctions=GestionAuctionDelegate.doFindAllAuctionsByProductName(product.getName());
			initDataBindings();
			}
			
		});
		btnRefreshTable.setBounds(409, 154, 202, 23);
		add(btnRefreshTable);
		
		textField = new JTextField();
		textField.setBounds(214, 156, 185, 20);
		add(textField);
		textField.setColumns(10);
		
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<Auction, List<Auction>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, auctions, table);
		//
		BeanProperty<Auction, Date> auctionBeanProperty = BeanProperty.create("auctionEndDate");
		jTableBinding.addColumnBinding(auctionBeanProperty).setColumnName("Enddd Date").setEditable(false);
		//
		BeanProperty<Auction, String> auctionBeanProperty_1 = BeanProperty.create("class.simpleName");
		jTableBinding.addColumnBinding(auctionBeanProperty_1).setColumnName("Type").setEditable(false);
		//
		BeanProperty<Auction, Date> auctionBeanProperty_2 = BeanProperty.create("auctionStartingDate");
		jTableBinding.addColumnBinding(auctionBeanProperty_2).setColumnName("Starting Date").setEditable(false);
		//
		BeanProperty<Auction, Integer> auctionBeanProperty_3 = BeanProperty.create("auctionStartingPrice");
		jTableBinding.addColumnBinding(auctionBeanProperty_3).setColumnName("Starting Price").setEditable(false);
		//
		BeanProperty<Auction, String> auctionBeanProperty_4 = BeanProperty.create("product.name");
		jTableBinding.addColumnBinding(auctionBeanProperty_4).setColumnName("Product Name").setEditable(false);
		//
		BeanProperty<Auction, String> auctionBeanProperty_5 = BeanProperty.create("product.category");
		jTableBinding.addColumnBinding(auctionBeanProperty_5).setColumnName("Product Category").setEditable(false);
		//
		jTableBinding.bind();
	}
}

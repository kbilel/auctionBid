package tn.esprit.auction.gui.manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import tn.esprit.auction.delegate.GestionAuctionDelegate;
import tn.esprit.auction.delegate.GestionProductDelegate;
import tn.esprit.auction.domain.Product;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ConvertProductToAuction extends JFrame {

	private JPanel contentPane;
	private JTable table;
	List<Product>products;
	static Product productSelected;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConvertProductToAuction frame = new ConvertProductToAuction();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConvertProductToAuction() {
		products =new ArrayList<Product>();
		products=GestionProductDelegate.doFindAllProducts();
		setTitle("Convert a Product to an Auction");
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 47, 454, 301);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				productSelected=new Product();
				productSelected=products.get(table.getSelectedRow());
						}
		});
		
		//table.setModel(new TableProductModel());
		
		JLabel lblConvertAProduct = new JLabel("Convert a product to an Auction :");
		lblConvertAProduct.setBounds(28, 11, 192, 14);
		contentPane.add(lblConvertAProduct);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel lblYouNeedTo = new JLabel("You need to select a Product first !");
				lblYouNeedTo.setForeground(Color.RED);
				lblYouNeedTo.setBounds(40, 401, 301, 14);
				lblYouNeedTo.setVisible(false);
				contentPane.add(lblYouNeedTo);
				if (productSelected!=null ){
					if(GestionAuctionDelegate.doFindAllAuctionsByProduct(productSelected).size()==0){
				AddAuction frame = new AddAuction();
				frame.setVisible(true);
				setVisible(false);
				}else JOptionPane.showMessageDialog(null, "Product already in an auction !");
				}else lblYouNeedTo.setVisible(true);
			}
		});
		btnNewButton.setBounds(435, 427, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(296, 427, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblPleaseSelectA = new JLabel("Choose and select the product you want to convert to an auction from the table .");
		lblPleaseSelectA.setBounds(40, 360, 454, 14);
		contentPane.add(lblPleaseSelectA);
		
		
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Product, List<Product>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, products, table);
		//
		BeanProperty<Product, String> productBeanProperty = BeanProperty.create("category");
		jTableBinding.addColumnBinding(productBeanProperty).setColumnName("Category").setEditable(false);
		//
		BeanProperty<Product, String> productBeanProperty_1 = BeanProperty.create("name");
		jTableBinding.addColumnBinding(productBeanProperty_1).setColumnName("Name").setEditable(false);
		//
		BeanProperty<Product, Integer> productBeanProperty_2 = BeanProperty.create("price");
		jTableBinding.addColumnBinding(productBeanProperty_2).setColumnName("Price").setEditable(false);
		//
		BeanProperty<Product, Integer> productBeanProperty_3 = BeanProperty.create("quantity");
		jTableBinding.addColumnBinding(productBeanProperty_3).setColumnName("Quantity").setEditable(false);
		//
		jTableBinding.bind();
	}
}

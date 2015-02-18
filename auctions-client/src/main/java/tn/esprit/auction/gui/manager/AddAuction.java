package tn.esprit.auction.gui.manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import tn.esprit.auction.domain.AgregateAuction;
import tn.esprit.auction.domain.Auction;
import tn.esprit.auction.domain.DutchAuction;
import tn.esprit.auction.domain.EnglishAuction;
import tn.esprit.auction.domain.NegociatedAuction;
import tn.esprit.auction.domain.Product;
import tn.esprit.auction.domain.YankeeAuction;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;

import java.awt.Color;

public class AddAuction extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblH;
	private JLabel lblM;
	private JLabel label;
	private JLabel lblEndTime;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel lblStartingPrice;
	private JTextField txtfStartingPrice;
	private JLabel lblTd;
	private JPanel panel_1;
	private JComboBox comboBox;
	private JLabel lblType;
	private JButton button;
	private JButton button_1;
	private JLabel lblDataIsMissing;
	static Auction auction;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product product=new Product();
					AddAuction frame = new AddAuction();
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
	public AddAuction( ) {
		setTitle("Add Auction");
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Add Auction", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 72, 514, 139);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Starting Time :");
		lblNewLabel.setBounds(10, 36, 112, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(132, 33, 28, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(193, 33, 28, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(252, 33, 28, 20);
		panel.add(textField_2);
		
		lblH = new JLabel("m   :");
		lblH.setBounds(170, 33, 27, 20);
		panel.add(lblH);
		
		lblM = new JLabel("s  :");
		lblM.setBounds(229, 33, 27, 20);
		panel.add(lblM);
		
		label = new JLabel("h   :");
		label.setBounds(104, 33, 27, 20);
		panel.add(label);
		
		lblEndTime = new JLabel("End Time :");
		lblEndTime.setBounds(10, 72, 112, 14);
		panel.add(lblEndTime);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(132, 69, 28, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(193, 69, 28, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(252, 69, 28, 20);
		panel.add(textField_5);
		
		label_2 = new JLabel("m   :");
		label_2.setBounds(170, 69, 27, 20);
		panel.add(label_2);
		
		label_3 = new JLabel("s  :");
		label_3.setBounds(229, 69, 27, 20);
		panel.add(label_3);
		
		label_4 = new JLabel("h   :");
		label_4.setBounds(104, 69, 27, 20);
		panel.add(label_4);
		
		lblStartingPrice = new JLabel("Starting Price :");
		lblStartingPrice.setBounds(10, 100, 112, 14);
		panel.add(lblStartingPrice);
		
		txtfStartingPrice = new JTextField();
		txtfStartingPrice.setColumns(10);
		txtfStartingPrice.setBounds(132, 97, 89, 20);
		panel.add(txtfStartingPrice);
		
		lblTd = new JLabel("TD");
		lblTd.setBounds(229, 100, 27, 20);
		panel.add(lblTd);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Auction Type", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 250, 514, 65);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"English Auction", "Dutch Auction", "Negociated Auction", "Yankee Auction", "Agregate Auction"}));
		comboBox.setBounds(132, 28, 188, 20);
		panel_1.add(comboBox);
		
		lblType = new JLabel("Type :");
		lblType.setBounds(10, 31, 112, 14);
		panel_1.add(lblType);
		
		button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {setVisible(false);
				ConvertProductToAuction convertProductToAuction=new ConvertProductToAuction();
				convertProductToAuction.setVisible(true);
				
				
			}
		});
		button.setBounds(296, 427, 89, 23);
		contentPane.add(button);
		
		button_1 = new JButton("Next");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Label data is missing
				lblDataIsMissing = new JLabel("Data is wrong or missing !");
				lblDataIsMissing.setForeground(Color.RED);
				lblDataIsMissing.setBounds(45, 380, 200, 14);
				lblDataIsMissing.setVisible(false);
				contentPane.add(lblDataIsMissing);
				// *** end label data is missing
				
				// recuperatio de produit
				ConvertProductToAuction convertProductToAuction=new ConvertProductToAuction();
			Product product=new Product();
			product = convertProductToAuction.productSelected;
				// ** end recuperation produit
			
				if (txtfStartingPrice.getText().equals("") ){
					lblDataIsMissing.setVisible(true);
					
				}else {
				
				String selectedComboBox =(String) comboBox.getSelectedItem();
				
					if (selectedComboBox=="English Auction"){
						auction =new EnglishAuction();
						auction.setAuctionStartingPrice(Integer.parseInt(txtfStartingPrice.getText()));
						auction.setProduct(product);
						AddEnglishAuction frame = new AddEnglishAuction();
						frame.setVisible(true);
						setVisible(false);
				}else if(selectedComboBox=="Agregate Auction"){
					auction =new AgregateAuction();
					auction.setAuctionStartingPrice(Integer.parseInt(txtfStartingPrice.getText()));
					auction.setProduct(product);
					AddAgregateAuction frame = new AddAgregateAuction();
					frame.setVisible(true);
					setVisible(false);
			}else if(selectedComboBox=="Dutch Auction"){
				auction =new DutchAuction();
				auction.setAuctionStartingPrice(Integer.parseInt(txtfStartingPrice.getText()));
				auction.setProduct(product);
				AddDutchAuction frame = new AddDutchAuction();
				frame.setVisible(true);
				setVisible(false);
		}else if(selectedComboBox=="Yankee Auction"){
			auction =new YankeeAuction();
			auction.setAuctionStartingPrice(Integer.parseInt(txtfStartingPrice.getText()));
			auction.setProduct(product);
			AddYankeeAuction frame = new AddYankeeAuction();
			frame.setVisible(true);
			setVisible(false);
	}else if(selectedComboBox=="Negociated Auction"){
		auction =new NegociatedAuction();
		auction.setAuctionStartingPrice(Integer.parseInt(txtfStartingPrice.getText()));
		auction.setProduct(product);
		AddNegociatedAuction frame = new AddNegociatedAuction();
		frame.setVisible(true);
		setVisible(false);
}
					
					}
			}
		});
		button_1.setBounds(435, 427, 89, 23);
		contentPane.add(button_1);
		
		
	}
}

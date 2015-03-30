package tn.esprit.auction.gui.manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JSpinner;



import javax.swing.UIManager;



public class AddAuction extends JFrame {

	private JPanel contentPane;
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
	private JSpinner spinner_1;
	private JSpinner spinner_2;
	private JSpinner spinner_3;
	private JSpinner spinner_4;
	private JSpinner spinner_5;
	com.toedter.calendar.JCalendar calendar = new com.toedter.calendar.JCalendar();
	com.toedter.calendar.JCalendar calendar_1 = new com.toedter.calendar.JCalendar();
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
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Start", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 39, 258, 258);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Starting Time :");
		lblNewLabel.setBounds(10, 35, 99, 14);
		panel.add(lblNewLabel);
		
		final JSpinner spinner = new JSpinner();
		spinner.setBounds(114, 35, 39, 20);
		panel.add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setBounds(160, 35, 39, 20);
		panel.add(spinner_1);
		
		spinner_2 = new JSpinner();
		spinner_2.setBounds(209, 35, 39, 20);
		panel.add(spinner_2);
		
		
		calendar.setBounds(24, 92, 205, 153);
		panel.add(calendar);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Auction Type", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 297, 514, 65);
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
			public void actionPerformed(ActionEvent e) {
				ConvertProductToAuction.productSelected=null;

				setVisible(false);
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
				
				Product product=new Product();
				product = ConvertProductToAuction.productSelected;
				ConvertProductToAuction.productSelected=null;
				// ** end recuperation produit
			
				if (txtfStartingPrice.getText().equals("") ){
					lblDataIsMissing.setVisible(true);
					
				}else {
				// auctionStartingDate recuperation des valeurs
				
				
				Integer yearS = calendar.getYearChooser().getValue();
				
			
				Integer mounthS = calendar.getMonthChooser().getMonth();
				
				
				Integer dayS = calendar.getDayChooser().getDay();
			
				Integer hourS= (Integer) (spinner.getValue());
				Integer minuteS= (Integer) (spinner_1.getValue());
				Integer secondeS= (Integer) (spinner_2.getValue());
				String s=yearS+","+mounthS+","+dayS+","+hourS+","+minuteS+","+secondeS;
				
	Date auctionStartingDate=new Date(yearS-1900, mounthS, dayS, hourS, minuteS, secondeS);
		
				System.out.println("start"+s);
				// **** End auctionStartingDate recuperation de s valeurs
				
// auctionEndDate recuperation des valeurs
				

				Integer yearE = calendar_1.getYearChooser().getValue();
				
			
				Integer mounthE = calendar_1.getMonthChooser().getMonth();
				
				
				Integer dayE = calendar_1.getDayChooser().getDay();
			
				Integer hourE= (Integer) (spinner_3.getValue());
				Integer minuteE= (Integer) (spinner_4.getValue());
				Integer secondeE= (Integer) (spinner_5.getValue());
				String eND =yearE+","+mounthE+","+dayE+","+hourE+","+minuteE+","+secondeE;
				
	Date auctionEndDate=new Date(yearE-1900, mounthE, dayE, hourE, minuteE, secondeE);
				
				System.out.println(eND);
				// **** End auctionEndDate recuperation de s valeurs
				
				if (auctionEndDate.after(auctionStartingDate)){
					
				String selectedComboBox =(String) comboBox.getSelectedItem();
				
					if (selectedComboBox=="English Auction"){
						auction =new EnglishAuction();
						auction.setAuctionStartingPrice(Integer.parseInt(txtfStartingPrice.getText()));
						 
						auction.setAuctionStartingDate(auctionStartingDate);
						auction.setAuctionEndDate(auctionEndDate);
						auction.setProduct(product);
						AddEnglishAuction frame = new AddEnglishAuction();
						frame.setVisible(true);
						setVisible(false);
				}else if(selectedComboBox=="Agregate Auction"){
					auction =new AgregateAuction();
					auction.setAuctionStartingPrice(Integer.parseInt(txtfStartingPrice.getText()));
					auction.setAuctionStartingDate(auctionStartingDate);
					auction.setAuctionEndDate(auctionEndDate);
					auction.setProduct(product);
					AddAgregateAuction frame = new AddAgregateAuction();
					frame.setVisible(true);
					setVisible(false);
			}else if(selectedComboBox=="Dutch Auction"){
				auction =new DutchAuction();
				auction.setAuctionStartingPrice(Integer.parseInt(txtfStartingPrice.getText()));
				auction.setAuctionStartingDate(auctionStartingDate);
				auction.setAuctionEndDate(auctionEndDate);
				auction.setProduct(product);
				AddDutchAuction frame = new AddDutchAuction();
				frame.setVisible(true);
				setVisible(false);
		}else if(selectedComboBox=="Yankee Auction"){
			auction =new YankeeAuction();
			auction.setAuctionStartingPrice(Integer.parseInt(txtfStartingPrice.getText()));
			auction.setAuctionStartingDate(auctionStartingDate);
			auction.setAuctionEndDate(auctionEndDate);
			auction.setProduct(product);
			AddYankeeAuction frame = new AddYankeeAuction();
			frame.setVisible(true);
			setVisible(false);
	}else if(selectedComboBox=="Negociated Auction"){
		auction =new NegociatedAuction();
		auction.setAuctionStartingPrice(Integer.parseInt(txtfStartingPrice.getText()));
		auction.setAuctionStartingDate(auctionStartingDate);
		auction.setAuctionEndDate(auctionEndDate);
		auction.setProduct(product);
		AddNegociatedAuction frame = new AddNegociatedAuction();
		frame.setVisible(true);
		setVisible(false);
}
					
					}else 	JOptionPane.showMessageDialog(null, "Be carefull ! Date Start comes after Date End !!");
				}
			}
		});
		button_1.setBounds(435, 427, 89, 23);
		contentPane.add(button_1);
		
		lblStartingPrice = new JLabel("Starting Price :");
		lblStartingPrice.setBounds(20, 14, 112, 14);
		contentPane.add(lblStartingPrice);
		
		txtfStartingPrice = new JTextField();
		txtfStartingPrice.setBounds(158, 11, 89, 20);
		contentPane.add(txtfStartingPrice);
		txtfStartingPrice.setColumns(10);
		
		lblTd = new JLabel("TD");
		lblTd.setBounds(257, 11, 27, 20);
		contentPane.add(lblTd);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "End", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(266, 39, 258, 258);
		contentPane.add(panel_2);
		
		JLabel lblEndtime = new JLabel("End Time :");
		lblEndtime.setBounds(10, 35, 112, 14);
		panel_2.add(lblEndtime);
		
		spinner_3 = new JSpinner();
		spinner_3.setBounds(86, 32, 39, 20);
		panel_2.add(spinner_3);
		
		spinner_4 = new JSpinner();
		spinner_4.setBounds(132, 32, 39, 20);
		panel_2.add(spinner_4);
		
		spinner_5 = new JSpinner();
		spinner_5.setBounds(181, 32, 39, 20);
		panel_2.add(spinner_5);
		
		
		calendar_1.setBounds(23, 91, 205, 153);
		panel_2.add(calendar_1);
		
		
	}
}



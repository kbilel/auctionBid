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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JSpinner;



import javax.swing.UIManager;



public class UpdateAuction extends JFrame {

	private JPanel contentPane;
	private JLabel lblStartingPrice;
	private JTextField txtfStartingPrice;
	private JLabel lblTd;
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
					UpdateAuction frame = new UpdateAuction();
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
	public UpdateAuction( ) {
		setTitle("Update Auction");
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
		spinner.setValue(PanelManageAuction.auctionSelected.getAuctionStartingDate().getHours());
		panel.add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setBounds(160, 35, 39, 20);
		spinner_1.setValue(PanelManageAuction.auctionSelected.getAuctionStartingDate().getMinutes());
		panel.add(spinner_1);
		
		spinner_2 = new JSpinner();
		spinner_2.setBounds(209, 35, 39, 20);
		spinner_2.setValue(PanelManageAuction.auctionSelected.getAuctionStartingDate().getSeconds());
		panel.add(spinner_2);
		
		
		calendar.setBounds(24, 92, 205, 153);
		calendar.setDate(PanelManageAuction.auctionSelected.getAuctionStartingDate());
		panel.add(calendar);
		
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
				
	Date auctionEndDate=new Date(yearS-1900, mounthS, dayS, hourS, minuteS, secondeS);
				
				System.out.println(eND);
				// **** End auctionEndDate recuperation de s valeurs
			
				
					if (PanelManageAuction.auctionSelected instanceof EnglishAuction){
						auction =new EnglishAuction();
						auction.setAuctionStartingPrice(Integer.parseInt(txtfStartingPrice.getText()));
						 
						auction.setAuctionStartingDate(auctionStartingDate);
						auction.setAuctionEndDate(auctionEndDate);
						auction.setProduct(PanelManageAuction.auctionSelected.getProduct());
						UpdateEnglishAuction frame = new UpdateEnglishAuction();
						frame.setVisible(true);
						setVisible(false);
				}else if(PanelManageAuction.auctionSelected instanceof AgregateAuction){
					auction =new AgregateAuction();
					auction.setAuctionStartingPrice(Integer.parseInt(txtfStartingPrice.getText()));
					auction.setAuctionStartingDate(auctionStartingDate);
					auction.setAuctionEndDate(auctionEndDate);
					auction.setProduct(PanelManageAuction.auctionSelected.getProduct());
					UpdateAgregateAuction frame = new UpdateAgregateAuction();
					frame.setVisible(true);
					setVisible(false);
			}else if(PanelManageAuction.auctionSelected instanceof DutchAuction){
				auction =new DutchAuction();
				auction.setAuctionStartingPrice(Integer.parseInt(txtfStartingPrice.getText()));
				auction.setAuctionStartingDate(auctionStartingDate);
				auction.setAuctionEndDate(auctionEndDate);
				auction.setProduct(PanelManageAuction.auctionSelected.getProduct());
				UpdateDutchAuction frame = new UpdateDutchAuction();
				frame.setVisible(true);
				setVisible(false);
		}else if(PanelManageAuction.auctionSelected instanceof  YankeeAuction){
			auction =new YankeeAuction();
			auction.setAuctionStartingPrice(Integer.parseInt(txtfStartingPrice.getText()));
			auction.setAuctionStartingDate(auctionStartingDate);
			auction.setAuctionEndDate(auctionEndDate);
			auction.setProduct(PanelManageAuction.auctionSelected.getProduct());
			UpdateYankeeAuction frame = new UpdateYankeeAuction();
			frame.setVisible(true);
			setVisible(false);
	}else if(PanelManageAuction.auctionSelected instanceof  NegociatedAuction){
		auction =new NegociatedAuction();
		auction.setAuctionStartingPrice(Integer.parseInt(txtfStartingPrice.getText()));
		auction.setAuctionStartingDate(auctionStartingDate);
		auction.setAuctionEndDate(auctionEndDate);
		auction.setProduct(PanelManageAuction.auctionSelected.getProduct());
		UpdateNegociatedAuction frame = new UpdateNegociatedAuction();
		frame.setVisible(true);
		setVisible(false);
}
					
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
		txtfStartingPrice.setText(PanelManageAuction.auctionSelected.getAuctionStartingPrice().toString());
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
		spinner_3.setValue(PanelManageAuction.auctionSelected.getAuctionEndDate().getHours());
		panel_2.add(spinner_3);
		
		spinner_4 = new JSpinner();
		spinner_4.setBounds(132, 32, 39, 20);
		spinner_4.setValue(PanelManageAuction.auctionSelected.getAuctionEndDate().getMinutes());
		panel_2.add(spinner_4);
		
		spinner_5 = new JSpinner();
		spinner_5.setBounds(181, 32, 39, 20);
		spinner_5.setValue(PanelManageAuction.auctionSelected.getAuctionEndDate().getSeconds());
		panel_2.add(spinner_5);
		
		
		calendar_1.setBounds(23, 91, 205, 153);
		calendar_1.setDate(PanelManageAuction.auctionSelected.getAuctionEndDate());
		panel_2.add(calendar_1);
		
		
	}
}



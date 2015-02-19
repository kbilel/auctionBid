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
import javax.swing.ImageIcon;
import javax.transaction.Transactional.TxType;

import tn.esprit.auction.delegate.GestionAuctionDelegate;
import tn.esprit.auction.domain.AgregateAuction;
import tn.esprit.auction.domain.DutchAuction;
import tn.esprit.auction.domain.EnglishAuction;
import tn.esprit.auction.domain.NegociatedAuction;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddNegociatedAuction extends JFrame {

	private JPanel contentPane;
	private JButton button;
	private JButton btnFinish;
	private JLabel lblNewLabel_1;
	private JLabel lblByClickingFinish;
	private JLabel lblDecreaseValue;
	private JTextField textField;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNegociatedAuction frame = new AddNegociatedAuction();
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
	public AddNegociatedAuction() {
		setTitle("Add Negociated Auction");
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddAuction addAuction=new AddAuction();
				addAuction.setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(296, 427, 89, 23);
		contentPane.add(button);
		
		btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel = new JLabel("Data is wrong or missing !");
				lblNewLabel.setForeground(Color.RED);
				lblNewLabel.setBounds(55, 375, 187, 14);
				lblNewLabel.setVisible(false);
				contentPane.add(lblNewLabel);
				if(textField.getText().equals("") ){
					lblNewLabel.setVisible(true);
				}else{
				AddAuction addAuction=new AddAuction();
				NegociatedAuction negociatedAuction=(NegociatedAuction) AddAuction.auction;
				negociatedAuction.setFixedMinimumPrice(Integer.parseInt(textField.getText()));
				
				GestionAuctionDelegate.doAddAuction(negociatedAuction);
				setVisible(false);
			}}
		});
		btnFinish.setBounds(435, 427, 89, 23);
		contentPane.add(btnFinish);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AddNegociatedAuction.class.getResource("/tn/esprit/auction/gui/manager/negociated.jpg")));
		lblNewLabel_1.setBounds(94, 11, 412, 200);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNoMoreData = new JLabel(" Negociated Auction !");
		lblNoMoreData.setBounds(45, 222, 322, 14);
		contentPane.add(lblNoMoreData);
		
		lblByClickingFinish = new JLabel("By clicking Finish , an email will be send to notify interested clients in this category of auction!");
		lblByClickingFinish.setBounds(10, 356, 461, 14);
		contentPane.add(lblByClickingFinish);
		
		lblDecreaseValue = new JLabel("Fixed minimum price :");
		lblDecreaseValue.setBounds(10, 262, 136, 14);
		contentPane.add(lblDecreaseValue);
		
		textField = new JTextField();
		textField.setBounds(223, 259, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
	}
}
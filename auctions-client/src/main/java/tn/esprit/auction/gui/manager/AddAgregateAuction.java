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

import tn.esprit.auction.delegate.GestionAuctionDelegate;
import tn.esprit.auction.domain.AgregateAuction;
import tn.esprit.auction.domain.EnglishAuction;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddAgregateAuction extends JFrame {

	private JPanel contentPane;
	private JButton button;
	private JButton btnFinish;
	private JLabel lblNewLabel_1;
	private JLabel lblByClickingFinish;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAgregateAuction frame = new AddAgregateAuction();
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
	public AddAgregateAuction() {
		setTitle("Add Agregate Auction");
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
				AddAuction addAuction=new AddAuction();
				AgregateAuction agregateAuction=(AgregateAuction) AddAuction.auction;
				GestionAuctionDelegate.doAddAuction(agregateAuction);
				setVisible(false);
			}
		});
		btnFinish.setBounds(435, 427, 89, 23);
		contentPane.add(btnFinish);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AddAgregateAuction.class.getResource("/tn/esprit/auction/gui/manager/aggregate auction.png")));
		lblNewLabel_1.setBounds(120, 23, 333, 291);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNoMoreData = new JLabel("No more data to input  in Agregate Auction !");
		lblNoMoreData.setBounds(45, 365, 322, 14);
		contentPane.add(lblNoMoreData);
		
		lblByClickingFinish = new JLabel("By clicking Finish , an email will be send to notify interested clients in this category of auction!");
		lblByClickingFinish.setBounds(45, 390, 461, 14);
		contentPane.add(lblByClickingFinish);
	}
}

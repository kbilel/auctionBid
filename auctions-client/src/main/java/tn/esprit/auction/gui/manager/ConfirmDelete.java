package tn.esprit.auction.gui.manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import tn.esprit.auction.delegate.GestionAuctionDelegate;
import tn.esprit.auction.domain.Auction;

public class ConfirmDelete extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmDelete frame = new ConfirmDelete();
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
	public ConfirmDelete() {
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionAuctionDelegate gestionAuctionDelegate= new GestionAuctionDelegate();
				PanelManageAuction panelManageAuction=new PanelManageAuction();
				Auction auction=new Auction();
				auction=PanelManageAuction.auctionSelected;
				GestionAuctionDelegate.doDeleteAuction(auction);
				PanelManageAuction.auctionSelected=null;
				panelManageAuction.initDataBindings();
				setVisible(false);
				
			}
		});
		btnNewButton.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblAreYouSure = new JLabel("Are you sure , you want to delete the selected Auction ? !");
		lblAreYouSure.setBounds(38, 76, 374, 41);
		contentPane.add(lblAreYouSure);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ConfirmDelete.class.getResource("/javax/swing/plaf/metal/icons/ocean/warning.png")));
		label.setBounds(172, 29, 83, 32);
		contentPane.add(label);
	}
}

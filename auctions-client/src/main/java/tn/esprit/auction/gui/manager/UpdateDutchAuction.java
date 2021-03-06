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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UpdateDutchAuction extends JFrame {

	private JPanel contentPane;
	private JButton button;
	private JButton btnFinish;
	private JLabel lblNewLabel_1;
	private JLabel lblDecreaseValue;
	private JLabel lblDecreaseTimeValue;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JLabel lblByClickingFinish;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDutchAuction frame = new UpdateDutchAuction();
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
	public UpdateDutchAuction() {
		setTitle("Update Dutch Auction");
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UpdateAuction updateAuction=new UpdateAuction();
				updateAuction.setVisible(true);
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
				if(textField.getText().equals("") ||textField_1.getText().equals("")){
					lblNewLabel.setVisible(true);
				}else{
				
				DutchAuction dutchAuction=(DutchAuction) UpdateAuction.auction;
				dutchAuction.setDecreaseTimeValue(Integer.parseInt(textField_1.getText()));
				dutchAuction.setDecreaseValue(Integer.parseInt(textField.getText()));
				dutchAuction.setId(PanelManageAuction.auctionSelected.getId());
				GestionAuctionDelegate.doUpdateAuction(dutchAuction);
				ConfirmSendMail confirmSendMail=new ConfirmSendMail();
				confirmSendMail.setVisible(true);
				setVisible(false);
			}}
		});
		btnFinish.setBounds(435, 427, 89, 23);
		contentPane.add(btnFinish);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(UpdateDutchAuction.class.getResource("/tn/esprit/auction/gui/manager/Dutch-Auction1.png")));
		lblNewLabel_1.setBounds(59, 11, 412, 200);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNoMoreData = new JLabel(" Dutch Auction !");
		lblNoMoreData.setBounds(45, 222, 322, 14);
		contentPane.add(lblNoMoreData);
		
		lblDecreaseValue = new JLabel("Decrease value :");
		lblDecreaseValue.setBounds(45, 269, 103, 14);
		contentPane.add(lblDecreaseValue);
		
		lblDecreaseTimeValue = new JLabel("Decrease time value :");
		lblDecreaseTimeValue.setBounds(45, 294, 161, 20);
		contentPane.add(lblDecreaseTimeValue);
		
		textField = new JTextField();
		textField.setBounds(216, 262, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(216, 294, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblByClickingFinish = new JLabel("By clicking Finish , a new auction will be updated !");
		lblByClickingFinish.setBounds(10, 325, 490, 14);
		contentPane.add(lblByClickingFinish);
		
		
	}
}

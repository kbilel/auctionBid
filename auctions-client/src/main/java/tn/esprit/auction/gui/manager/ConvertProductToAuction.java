package tn.esprit.auction.gui.manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConvertProductToAuction extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
		//table.setModel(new TableProductModel());
		
		JLabel lblConvertAProduct = new JLabel("Convert a product to an Auction :");
		lblConvertAProduct.setBounds(28, 11, 192, 14);
		contentPane.add(lblConvertAProduct);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAuction frame = new AddAuction();
				frame.setVisible(true);
				setVisible(false);
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
	}
}

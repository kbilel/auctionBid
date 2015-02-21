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

public class ErreurSelection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErreurSelection frame = new ErreurSelection();
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
	public ErreurSelection() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnOk.setBounds(335, 227, 89, 23);
		contentPane.add(btnOk);
		
		JLabel lblNoAuctionIs = new JLabel("No auction is selected , please select an auction !");
		lblNoAuctionIs.setBounds(10, 104, 345, 52);
		contentPane.add(lblNoAuctionIs);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ErreurSelection.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
		label.setBounds(194, 31, 126, 59);
		contentPane.add(label);
	}

}

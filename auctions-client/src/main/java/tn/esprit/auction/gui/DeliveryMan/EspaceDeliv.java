package tn.esprit.auction.gui.DeliveryMan;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.awt.ScrollPaneAdjustable;

import javax.naming.InitialContext;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import tn.esprit.auction.delegate.GestionUserDelegate;
import tn.esprit.auction.domain.User;
import tn.esprit.auction.services.gestion.user.UserServicesRemote;
import java.awt.Color;
import javax.swing.JTable;

public class EspaceDeliv extends JFrame {

	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EspaceDeliv frame = new EspaceDeliv();
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
	public EspaceDeliv() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 510);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDz = new JLabel("Order Management");
		lblDz.setForeground(Color.RED);
		lblDz.setBounds(149, 41, 176, 47);
		contentPane.add(lblDz);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 124, 295, 237);
		contentPane.add(scrollPane);
	}
}

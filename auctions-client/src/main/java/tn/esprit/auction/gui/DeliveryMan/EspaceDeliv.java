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

public class EspaceDeliv extends JFrame {

	private JPanel contentPane;
	Delivpa delivpa;
	private JTextField textField;
	private JTextField textField_1;

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
		
		JMenuItem mntmHome = new JMenuItem("home");
		menuBar.add(mntmHome);
		
		JMenuItem mntmProfile = new JMenuItem("profile");
		mntmProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				
			}
		});
		menuBar.add(mntmProfile);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("Username");
		lblNom.setBounds(24, 108, 61, 14);
		contentPane.add(lblNom);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(24, 158, 61, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(115, 105, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(115, 155, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAjouter = new JButton("ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user1=new User();
				user1.setFullName(textField.getText());
				user1.setPassword(textField_1.getText());
				GestionUserDelegate.doAddUser(user1);
			
			
				
			}
		});
		btnAjouter.setBounds(112, 227, 89, 23);
		contentPane.add(btnAjouter);
	}
}

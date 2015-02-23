package tn.esprit.auction.gui.admin;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import tn.esprit.auction.delegate.GestionConfigurationDelegate;
import tn.esprit.auction.delegate.GestionStaffDelegate;
import tn.esprit.auction.delegate.GestionUserDelegate;
import tn.esprit.auction.domain.Client;
import tn.esprit.auction.domain.Configuration;
import tn.esprit.auction.domain.Manager;
import tn.esprit.auction.gui.admin.*;
import tn.esprit.auction.gui.client.EspaceClient;
import tn.esprit.auction.gui.manager.AddAuction;

public class AddManagerUnused extends JPanel {
	private JTextField tfUsername;
	private JTextField tfLogin;
	private JTextField tfAdresse;
	private JPasswordField passwordField;
	private JTextField tfEmail;
	private JTextField tfPathImage;
	private JPanel contentPane;
	/**
	 * Create the panel.
	 */

	public AddManagerUnused() {
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Add m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(5, 5, 5, 5);
		add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(-265, 0, 658, 497);
		panel.add(label);
		
		JLabel lblFirsName = new JLabel("username :");
		lblFirsName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFirsName.setBounds(23, 456, 160, 41);
		panel.add(lblFirsName);
		
		JLabel lblLastName = new JLabel("login :");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLastName.setBounds(23, 512, 160, 41);
		panel.add(lblLastName);
		
		JLabel lblLogin = new JLabel("password :");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setBounds(23, 557, 160, 41);
		panel.add(lblLogin);
		
		JLabel lblPassword = new JLabel("email:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(23, 606, 160, 41);
		panel.add(lblPassword);
		
		JLabel lblEmail = new JLabel("adresse :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmail.setBounds(23, 660, 160, 41);
		panel.add(lblEmail);
		tfUsername = new JTextField();
		tfUsername.setBounds(238, 460, 368, 41);
		panel.add(tfUsername);
		tfUsername.setColumns(10);
		
		tfLogin = new JTextField();
		tfLogin.setColumns(10);
		tfLogin.setBounds(238, 512, 368, 41);
		panel.add(tfLogin);
		
		tfAdresse = new JTextField();
		tfAdresse.setColumns(10);
		tfAdresse.setBounds(238, 664, 368, 41);
		panel.add(tfAdresse);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(238, 564, 368, 35);
		panel.add(passwordField);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(238, 610, 368, 41);
		panel.add(tfEmail);
		
		JButton btnRegister = new JButton("valider");
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager manager = new Manager();
				manager.setFullName(tfUsername.getText());
				manager.setEmail(tfEmail.getText());
				manager.setAdress(tfAdresse.getText());
				manager.setUserName(tfLogin.getText());
				manager.setPassword(new String(passwordField.getText()));
				manager.setImageUrl(tfPathImage.getText());
				
				if(GestionStaffDelegate.doAddManager(manager))
				 {
					 
					 new EspaceAdministrator().setVisible(true);
					 setVisible(false);
					 System.out.println("ouiiiiii ajouté ");
				 }
				
				
			}
		});
		btnRegister.setBounds(296, 670, 89, 23);
		contentPane.add(btnRegister);

	}
}

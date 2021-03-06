package tn.esprit.auction.gui.admin;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import tn.esprit.auction.delegate.GestionStaffDelegate;
import tn.esprit.auction.domain.BookKeeper;

public class AddBookKeeper extends JPanel {
	private JTextField tfLogin;
	private JTextField passwordField;
	private JTextField tfEmail;
	private JTextField tfName;
	private JTextField tfAdresse;

	/**
	 * Create the panel.
	 */
	public AddBookKeeper() {
		setLayout(null);
		setBounds(0, 0, 1800, 750);
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "add user", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(0, 0, 1800, 750);
		add(panel);
		panel.setLayout(null);
		
		tfAdresse = new JTextField();
		tfAdresse.setBounds(168, 172, 86, 20);
		panel.add(tfAdresse);
		tfAdresse.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("address");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel.setBounds(34, 172, 86, 17);
		panel.add(lblNewLabel);
		
		tfLogin = new JTextField();
		tfLogin.setBounds(168, 48, 86, 20);
		panel.add(tfLogin);
		tfLogin.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(168, 79, 86, 20);
		panel.add(passwordField);
		passwordField.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(168, 110, 86, 20);
		panel.add(tfEmail);
		tfEmail.setColumns(10);
		
		tfName = new JTextField();
		tfName.setBounds(168, 141, 86, 20);
		panel.add(tfName);
		tfName.setColumns(10);
		
		JButton btnSave = new JButton("save");
		btnSave.setBounds(125, 203, 89, 23);
		panel.add(btnSave);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddBookKeeper.class.getResource("/tn/esprit/auction/gui/client/back.jpg")));
		label.setBounds(0, 0, 1800, 750);
		panel.add(label);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setBounds(34, 45, 110, 23);
		panel.add(lblUsername);
		lblUsername.setFont(new Font("Tahoma", Font.ITALIC, 20));
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(29, 75, 110, 20);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.ITALIC, 20));
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(34, 110, 110, 20);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.ITALIC, 20));
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(29, 137, 110, 21);
		panel.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookKeeper bookKeeper= new BookKeeper();
				bookKeeper.setFullName(tfName.getText());
				bookKeeper.setEmail(tfEmail.getText());
				bookKeeper.setAdress(tfAdresse.getText());
				bookKeeper.setUserName(tfLogin.getText());
				bookKeeper.setPassword(new String(passwordField.getText()));
				bookKeeper.setImageUrl("/tn/esprit/auction/gui/client/back.jpg");
				
				
				
				if(GestionStaffDelegate.doAddBookKeeper(bookKeeper))
				 {JOptionPane.showMessageDialog(null, "ok...");
			}
				else {}
			}
		});

	}
	
}

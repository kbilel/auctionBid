package tn.esprit.auction.gui.DeliveryMan;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.BevelBorder;

import tn.esprit.auction.gui.client.HomeClient;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Font;

public class PanelProfile extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelProfile() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Profil informations", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		panel.setBounds(10, 29, 488, 377);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblFullname = new JLabel("Fullname :");
		lblFullname.setBounds(10, 36, 62, 14);
		panel.add(lblFullname);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 90, 62, 14);
		panel.add(lblUsername);
		
		JLabel lblAdress = new JLabel("Adress     :");
		lblAdress.setBounds(10, 187, 62, 14);
		panel.add(lblAdress);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Aharoni", Font.BOLD, 12));
		lblNewLabel.setText(" "+ HomeClient.getUser().getFullName());
		
		lblNewLabel.setBounds(82, 36, 106, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Aharoni", Font.BOLD, 12));
		lblNewLabel_1.setText(" "+ HomeClient.getUser().getUserName());
		lblNewLabel_1.setBounds(82, 90, 106, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Aharoni", Font.BOLD, 12));
		lblNewLabel_2.setText(" "+ HomeClient.getUser().getAdress());
		lblNewLabel_2.setBounds(82, 187, 106, 14);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Profil picture", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		panel_1.setBounds(219, 36, 259, 271);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(EspaceDeliveryMan.class.getResource(HomeClient.getUser().getImageUrl())));
		label.setBounds(10, 23, 239, 207);
		panel_1.add(label);
		
		JLabel lblEmail = new JLabel("Email       :");
		lblEmail.setBounds(10, 134, 62, 14);
		panel.add(lblEmail);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("Aharoni", Font.BOLD, 12));
		label_1.setText(" "+ HomeClient.getUser().getEmail());
		label_1.setBounds(82, 136, 127, 14);
		panel.add(label_1);

	}

}

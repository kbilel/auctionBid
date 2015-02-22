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

public class PanelProfile extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelProfile() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Profil informations", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		panel.setBounds(10, 29, 412, 233);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblFullname = new JLabel("Fullname   :");
		lblFullname.setBounds(10, 36, 62, 14);
		panel.add(lblFullname);
		
		JLabel lblUsername = new JLabel("Username  :");
		lblUsername.setBounds(10, 90, 62, 14);
		panel.add(lblUsername);
		
		JLabel lblAdress = new JLabel("Adress     :");
		lblAdress.setBounds(10, 142, 62, 14);
		panel.add(lblAdress);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setText(" "+ HomeClient.getUser().getFullName());
		
		lblNewLabel.setBounds(101, 36, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setText(" "+ HomeClient.getUser().getUserName());
		lblNewLabel_1.setBounds(101, 90, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setText(" "+ HomeClient.getUser().getAdress());
		lblNewLabel_2.setBounds(101, 142, 46, 14);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Profil picture", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		panel_1.setBounds(252, 36, 150, 174);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(EspaceDeliveryMan.class.getResource(HomeClient.getUser().getImageUrl())));
		label.setBounds(33, 64, 46, 14);
		panel_1.add(label);

	}

}

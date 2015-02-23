package tn.esprit.auction.gui.stockManager;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import tn.esprit.auction.gui.DeliveryMan.EspaceDeliveryMan;
import tn.esprit.auction.gui.client.HomeClient;

public class PanelStockManagerProfile extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelStockManagerProfile() {
setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Profile details", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(10, 29, 581, 426);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblFullname = new JLabel("Full Name :");
		lblFullname.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblFullname.setBounds(10, 36, 78, 14);
		panel.add(lblFullname);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUsername.setBounds(10, 90, 78, 14);
		panel.add(lblUsername);
		
		JLabel lblAdress = new JLabel("Adress     :");
		lblAdress.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAdress.setBounds(10, 187, 78, 14);
		panel.add(lblAdress);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Aharoni", Font.BOLD, 12));
		lblNewLabel.setText(" "+ HomeClient.getUser().getFullName());
		
		lblNewLabel.setBounds(103, 38, 106, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Aharoni", Font.BOLD, 12));
		lblNewLabel_1.setText(" "+ HomeClient.getUser().getUserName());
		lblNewLabel_1.setBounds(103, 92, 106, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Aharoni", Font.BOLD, 12));
		lblNewLabel_2.setText(" "+ HomeClient.getUser().getAdress());
		lblNewLabel_2.setBounds(103, 188, 106, 14);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Profile picture", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1.setBounds(219, 36, 259, 271);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(EspaceStockManager.class.getResource(HomeClient.getUser().getImageUrl())));
		label.setBounds(10, 23, 239, 207);
		panel_1.add(label);
		
		JLabel lblEmail = new JLabel("Email       :");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEmail.setBounds(10, 134, 78, 14);
		panel.add(lblEmail);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("Aharoni", Font.BOLD, 12));
		label_1.setText(" "+ HomeClient.getUser().getEmail());
		label_1.setBounds(103, 135, 106, 14);
		panel.add(label_1);

	}

}

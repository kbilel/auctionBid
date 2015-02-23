package tn.esprit.auction.gui.admin;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

import tn.esprit.auction.domain.User;
import tn.esprit.auction.gui.client.EspaceClient;
import tn.esprit.auction.gui.client.HomeClient;
import tn.esprit.auction.gui.client.SubscribingPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeAdmin extends JPanel {
	static User userConnected;
	/**
	 * Create the panel.
	 */
	public HomeAdmin(JScrollPane scrollPane) {
		userConnected = HomeClient.userConnected;
				
		setBounds(0, 50, 1158, 750);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1158, 750);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(238, 232, 170));
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_1.setBounds(836, 118, 261, 268);
		panel.add(panel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(HomeAdmin.class.getResource("/tn/esprit/auction/gui/authentification/User-icon.png")));
		label.setBounds(23, 11, 214, 173);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("            ---------");
		label_1.setBounds(87, 195, 164, 25);
		
		panel_1.add(label_1);
		
		JButton button = new JButton("disconnect");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userConnected=null;
new EspaceClient().setVisible(true);
                  setVisible(false);
				
				
				
			}
		});
		button.setBounds(79, 222, 136, 35);
		panel_1.add(button);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(HomeAdmin.class.getResource("/tn/esprit/auction/gui/client/back.jpg")));
		label_2.setBounds(0, 0, 1158, 750);
		panel.add(label_2);

	}

}

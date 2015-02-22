package tn.esprit.auction.gui.admin;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.border.TitledBorder;

public class PanelHomeAdmin extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelHomeAdmin() {
		setBorder(new TitledBorder(null, "Manage User", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(PanelHomeAdmin.class.getResource("/tn/esprit/auction/gui/manager/bid.png")));
		label_2.setBounds(21, 11, 120, 116);
		add(label_2);
		
		JLabel label_3 = new JLabel("Administrator  Space");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 40));
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(241, 36, 659, 74);
		add(label_3);
		
		JLabel label_4 = new JLabel("Home");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 70));
		label_4.setBounds(205, 240, 277, 130);
		add(label_4);

	}
}

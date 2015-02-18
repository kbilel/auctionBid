package tn.esprit.auction.gui.DeliveryMan;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class Delivpa extends JPanel {

	/**
	 * Create the panel.
	 */
	public Delivpa() {
		setBorder(new TitledBorder(null, "test me", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		setLayout(null);
		
		JLabel lblHelloWorld = new JLabel("hello world*");
		lblHelloWorld.setBounds(158, 134, 57, 14);
		add(lblHelloWorld);
		
		JButton btnClickMe = new JButton("click me");
		btnClickMe.setBounds(138, 194, 89, 23);
		add(btnClickMe);

	}
}

package tn.esprit.auction.gui.DeliveryMan;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class HomeDelivery extends JPanel {

	/**
	 * Create the panel.
	 */
	public HomeDelivery() {
		setLayout(null);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(HomeDelivery.class.getResource("/tn/esprit/auction/gui/DeliveryMan/images.jpg")));
		button.setBounds(90, 92, 332, 219);
		add(button);

	}
}

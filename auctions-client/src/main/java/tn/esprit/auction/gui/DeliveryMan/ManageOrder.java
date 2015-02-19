package tn.esprit.auction.gui.DeliveryMan;

import javax.persistence.criteria.Order;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.util.List;

public class ManageOrder extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ManageOrder() {
		List<Order> orders;
		
		setBorder(new TitledBorder(null, "affichage", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		setLayout(null);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(25, 24, 396, 253);
		add(scrollPane2);
		
		table = new JTable();
		scrollPane2.setViewportView(table);

	}
}

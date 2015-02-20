package tn.esprit.auction.gui.DeliveryMan;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class PanelShowOrder extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelShowOrder() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "add", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 50, 396, 237);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnTakeOrder = new JButton("Take order");
		btnTakeOrder.setBounds(497, 318, 89, 23);
		add(btnTakeOrder);

	}
}

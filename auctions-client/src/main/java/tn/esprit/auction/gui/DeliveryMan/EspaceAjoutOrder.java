package tn.esprit.auction.gui.DeliveryMan;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EspaceAjoutOrder extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public EspaceAjoutOrder() {
		setLayout(null);
		
		JButton btnAddOrder = new JButton("add order");
		btnAddOrder.setBounds(171, 232, 89, 23);
		add(btnAddOrder);
		
		JLabel lblNewLabel = new JLabel("Date limit");
		lblNewLabel.setBounds(26, 121, 71, 14);
		add(lblNewLabel);
		
		JLabel lblClientId = new JLabel("Client ");
		lblClientId.setBounds(26, 96, 56, 14);
		add(lblClientId);
		
		JLabel lblNewLabel_1 = new JLabel("Cash payment");
		lblNewLabel_1.setBounds(26, 71, 89, 14);
		add(lblNewLabel_1);
		
		JLabel lblState = new JLabel("produit");
		lblState.setBounds(26, 146, 56, 14);
		add(lblState);
		
		textField = new JTextField();
		textField.setBounds(126, 68, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(126, 93, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(126, 118, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(126, 143, 86, 20);
		add(textField_3);
		textField_3.setColumns(10);

	}
}

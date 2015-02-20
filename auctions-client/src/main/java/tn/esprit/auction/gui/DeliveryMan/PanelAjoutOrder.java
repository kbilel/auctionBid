package tn.esprit.auction.gui.DeliveryMan;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class PanelAjoutOrder extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public PanelAjoutOrder() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "show", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		setLayout(null);
		
		JButton btnAdd = new JButton("add");
		btnAdd.setBounds(207, 193, 51, 23);
		add(btnAdd);
		
		textField = new JTextField();
		textField.setBounds(121, 76, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(121, 125, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblId = new JLabel("id order");
		lblId.setBounds(20, 79, 46, 14);
		add(lblId);
		
		JLabel lblIdClient = new JLabel("id client");
		lblIdClient.setBounds(20, 131, 46, 14);
		add(lblIdClient);

	}
}

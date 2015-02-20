package tn.esprit.auction.gui.DeliveryMan;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;

import tn.esprit.auction.delegate.GestionOrderDelegate;
import tn.esprit.auction.delegate.GestionUserDelegate;
import tn.esprit.auction.domain.Client;
import tn.esprit.auction.domain.Order;
import tn.esprit.auction.domain.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAjoutOrder extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public PanelAjoutOrder() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "ajout", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		setLayout(null);
		
		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Order order=new Order();
				order.setClient(Integer.parseInt(textField.getText()));
				order.setProduit(Integer.parseInt(textField_1.getText()));
				if(GestionOrderDelegate.doAddOrder(order))
					System.out.println("ajout succés");
				
			}
		});
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

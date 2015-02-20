package tn.esprit.auction.gui.DeliveryMan;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import tn.esprit.auction.delegate.GestionOrderDelegate;
import tn.esprit.auction.domain.Order;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EspaceAjoutOrder extends JPanel {
	private JTextField textField_1;
	private JTextField textField_3;

	Order order1;
	
	public EspaceAjoutOrder() {
		
		
		setLayout(null);
		
		JButton btnAddOrder = new JButton("add order");
		btnAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order1=new Order();
				order1.setClient(Integer.parseInt(textField_1.getText()));
				order1.setProduit(Integer.parseInt(textField_3.getText()));
				if(GestionOrderDelegate.doAddOrder(order1))
					System.out.println("ajout avec succés ");
				else
					System.out.println(" ajout echoué");
			}
		});
		btnAddOrder.setBounds(126, 232, 89, 23);
		add(btnAddOrder);
		
		JLabel lblClientId = new JLabel("IDClient ");
		lblClientId.setBounds(29, 40, 56, 14);
		add(lblClientId);
		
		JLabel lblState = new JLabel("IDproduit");
		lblState.setBounds(29, 90, 56, 14);
		add(lblState);
		
		textField_1 = new JTextField();
		textField_1.setBounds(129, 37, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(129, 87, 86, 20);
		add(textField_3);
		textField_3.setColumns(10);

	}
}

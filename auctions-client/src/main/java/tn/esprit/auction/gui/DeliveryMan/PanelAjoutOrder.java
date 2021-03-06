package tn.esprit.auction.gui.DeliveryMan;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;

import tn.esprit.auction.delegate.GestionOrderDelegate;
import tn.esprit.auction.delegate.GestionUserDelegate;
import tn.esprit.auction.domain.Client;
import tn.esprit.auction.domain.Order;
import tn.esprit.auction.domain.OrderPK;
import tn.esprit.auction.domain.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.transaction.Transactional.TxType;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PanelAjoutOrder extends JPanel {
	private JTextField textField_1;
	private JTextField textField_2;
	JComboBox comboBox;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public PanelAjoutOrder() {
		setForeground(Color.BLACK);
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "add an order", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		setLayout(null);
		
		JLabel lblDeliveryman = new JLabel("Client");
		lblDeliveryman.setBounds(10, 150, 87, 14);
		add(lblDeliveryman);
		
		JLabel lblManager = new JLabel("Product");
		lblManager.setBounds(10, 186, 75, 14);
		add(lblManager);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 147, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(143, 183, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon(PanelAjoutOrder.class.getResource("/tn/esprit/auction/gui/DeliveryMan/téléchargement.jpg")));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			Order order=new Order();
			OrderPK orderPK=new OrderPK();
			Date date=new Date();
			date.getTime();
			order.setDateLimit(date);
			orderPK.setIdClient(Integer.parseInt(textField_1.getText()));
			orderPK.setIdProduct(Integer.parseInt(textField_2.getText()));
			order.setOrderPK(orderPK);
			//order.setIdDeliveryMan(Integer.parseInt(textField.getText()));
			order.setAdressClient(textField_4.getText());
			order.setState("not delivred yet");
			
			String selectedComboBox =(String) comboBox.getSelectedItem();
			if (selectedComboBox=="Cash")
				order.setCashPayement(true);
			else order.setCashPayement(false);
		
		
			
		
			System.out.println("variable chargé");
			if(GestionOrderDelegate.doAddOrder(order))
			System.out.println("ajout avec succés");
			 JOptionPane.showMessageDialog(null, "Order is added to the order ! " );
		
		
			}
		});
		btnAdd.setBounds(291, 261, 122, 29);
		add(btnAdd);
		
		JLabel lblPayment = new JLabel("Payment ");
		lblPayment.setBounds(10, 268, 46, 14);
		add(lblPayment);
		
		 comboBox = new JComboBox();
		 comboBox.setForeground(Color.BLUE);

		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Paypal", "Cash"}));
		comboBox.setBounds(143, 261, 75, 29);
		add(comboBox);
		
		JLabel lblAdress = new JLabel("Adress");
		lblAdress.setBounds(10, 122, 46, 14);
		add(lblAdress);
		
		textField_4 = new JTextField();
		textField_4.setBounds(143, 116, 86, 20);
		add(textField_4);
		textField_4.setColumns(10);
		

	}
}

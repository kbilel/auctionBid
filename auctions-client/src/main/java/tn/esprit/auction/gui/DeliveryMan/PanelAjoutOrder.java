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
import tn.esprit.auction.domain.OrderPK;
import tn.esprit.auction.domain.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PanelAjoutOrder extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public PanelAjoutOrder() {
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"add an order", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(255, 0, 0)));
		setLayout(null);
		
		JLabel lblClient = new JLabel("Client");
		lblClient.setBounds(10, 41, 87, 14);
		add(lblClient);
		
		JLabel lblDeliveryman = new JLabel("Delivery Man");
		lblDeliveryman.setBounds(10, 137, 87, 14);
		add(lblDeliveryman);
		
		JLabel lblManager = new JLabel("Manager");
		lblManager.setBounds(10, 165, 75, 14);
		add(lblManager);
		
		textField = new JTextField();
		textField.setBounds(143, 38, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 134, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(143, 162, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon(PanelAjoutOrder.class.getResource("/tn/esprit/auction/gui/manager/téléchargement.jpg")));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Order order=new Order();
			OrderPK orderPK=new OrderPK();
			orderPK.setIdDeliveryMan(Integer.parseInt(textField_1.getText()));
			orderPK.setIdManager(Integer.parseInt(textField_2.getText()));
			order.setOrderPK(orderPK);
		
			System.out.println("variable chargé");
			if(GestionOrderDelegate.doAddOrder(order))
			System.out.println("ajout avec su");
			
		
			
			
	if(	GestionOrderDelegate.doAddOrder(order))
		System.out.println("ajouter avec sucess l'ordre");
		
			}
		});
		btnAdd.setBounds(243, 250, 122, 29);
		add(btnAdd);
		
		JLabel lblProduit = new JLabel("Produit");
		lblProduit.setBounds(10, 78, 46, 14);
		add(lblProduit);
		
		textField_3 = new JTextField();
		textField_3.setBounds(143, 69, 86, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDateOfPurchace = new JLabel("Date of purchace");
		lblDateOfPurchace.setBounds(10, 103, 87, 14);
		add(lblDateOfPurchace);
		
		textField_4 = new JTextField();
		textField_4.setBounds(143, 97, 86, 20);
		add(textField_4);
		textField_4.setColumns(10);

	}
}

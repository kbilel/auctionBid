package tn.esprit.auction.gui.stockManager;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import tn.esprit.auction.delegate.GestionProductDelegate;
import tn.esprit.auction.domain.Product;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAddProduct extends JPanel {
	private JTextField tfProdName;

	/**
	 * Create the panel.
	 */
	public PanelAddProduct() {
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "AddProduct", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 732, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(137, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(null);
		
		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setBounds(27, 43, 127, 14);
		panel.add(lblProductName);
		
		tfProdName = new JTextField();
		tfProdName.setBounds(121, 40, 189, 20);
		panel.add(tfProdName);
		tfProdName.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product product= new Product();
				product.setName(tfProdName.getText());
				if(GestionProductDelegate.doAddProduct(product)){
					JOptionPane.showMessageDialog(null, "ok ! product added");
					tfProdName.setText("");
					
					
				}
			}
		});
		btnAdd.setBounds(251, 102, 118, 23);
		panel.add(btnAdd);
		setLayout(groupLayout);

	}
}

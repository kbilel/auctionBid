package tn.esprit.auction.gui.admin;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import tn.esprit.auction.domain.*;

import javax.swing.JTabbedPane;

import tn.esprit.auction.delegate.GestionStaffDelegate;

import java.util.ArrayList;
import java.util.List;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.ObjectProperty;

import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;

public class GestionDeliveryMan extends JPanel {
	private JTable table;
	List<DeliveryMan> deliveryMans;
	AddDeliveryMan addDeliveryMan;
	//JScrollPane scrollPane;
	private JTextField tfName;
	private JTextField tfLogin;
	private JTextField passwordField;
	private JTextField tfEmail;
	DeliveryMan deliveryMan;
	JPanel panel;


	/**
	 * Create the panel.
	 */
	public GestionDeliveryMan() {
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 354, 281);
		deliveryMans =new ArrayList<DeliveryMan>();
		deliveryMans= GestionStaffDelegate.doFindAllDeliveryMan();
		scrollPane.setViewportView(table);
	

		JButton btnAdd = new JButton("add");
		btnAdd.setBounds(144, 368, 69, 23);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDeliveryMan addDeliveryMan= new AddDeliveryMan();
				scrollPane.setViewportView(addDeliveryMan);
			}
		});
		
		JButton btnEdit = new JButton("edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deliveryMan.setUserName(tfLogin.getText());
				deliveryMan.setPassword(passwordField.getText());
				deliveryMan.setEmail(tfEmail.getText());
				deliveryMan.setFullName(tfName.getText());
				if (GestionStaffDelegate.doUpdateDeliveryMan(deliveryMan))
				{JOptionPane.showMessageDialog(null, "ok...");
				tfLogin.setText("");
				passwordField.setText("");
				tfEmail.setText("");
				tfName.setText("");
				deliveryMans= GestionStaffDelegate.doFindAllDeliveryMan();
				initDataBindings();	
				}
				else {}
			}
		});
		btnEdit.setBounds(447, 368, 69, 23);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deliveryMan.setUserName(tfLogin.getText());
				deliveryMan.setPassword(passwordField.getText());
				deliveryMan.setEmail(tfEmail.getText());
				deliveryMan.setFullName(tfName.getText());
				if (GestionStaffDelegate.doDeleteDeliveryMan(deliveryMan))
				{JOptionPane.showMessageDialog(null, "delete :) ...");
				tfLogin.setText("");
				passwordField.setText("");
				tfEmail.setText("");
				tfName.setText("");
				deliveryMans= GestionStaffDelegate.doFindAllDeliveryMan();
				initDataBindings();	
				}
				else {}
			}
		});
		btnDelete.setBounds(280, 368, 79, 23);
		setLayout(null);
		
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			 deliveryMan = deliveryMans.get(table.getSelectedRow());
			
				
						 tfLogin.setText(deliveryMan.getUserName());
						 passwordField.setText(deliveryMan.getPassword());
						tfEmail.setText(deliveryMan.getEmail());
						 tfName.setText(deliveryMan.getFullName());
			}
		});
		add(btnEdit);
		add(btnAdd);
		add(btnDelete);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(429, 60, 352, 281);
		add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "Edit deliveryMan", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		tfName = new JTextField();
		tfName.setBounds(89, 146, 86, 20);
		panel_1.add(tfName);
		tfName.setColumns(10);
		
		tfLogin = new JTextField();
		tfLogin.setBounds(89, 53, 86, 20);
		panel_1.add(tfLogin);
		tfLogin.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(89, 84, 86, 20);
		panel_1.add(passwordField);
		passwordField.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(89, 115, 86, 20);
		panel_1.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblLogin = new JLabel("login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLogin.setBounds(29, 56, 46, 14);
		panel_1.add(lblLogin);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(29, 87, 58, 14);
		panel_1.add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(29, 118, 46, 14);
		panel_1.add(lblEmail);
		
		JLabel lblName = new JLabel("name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(29, 149, 46, 14);
		panel_1.add(lblName);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GestionDeliveryMan.class.getResource("/tn/esprit/auction/gui/admin/back1Config.jpg")));
		lblNewLabel.setBounds(0, 0, 1195, 753);
		add(lblNewLabel);
		initDataBindings();
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<DeliveryMan, List<DeliveryMan>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, deliveryMans, table);
		//
		BeanProperty<DeliveryMan, String> managerBeanProperty = BeanProperty.create("userName");
		jTableBinding.addColumnBinding(managerBeanProperty).setColumnName("name");
		//
		BeanProperty<DeliveryMan, String> managerBeanProperty_1 = BeanProperty.create("fullName");
		jTableBinding.addColumnBinding(managerBeanProperty_1).setColumnName("full name");
		//
		BeanProperty<DeliveryMan, String> managerBeanProperty_2 = BeanProperty.create("email");
		jTableBinding.addColumnBinding(managerBeanProperty_2).setColumnName("Email");
		//
		jTableBinding.bind();
	}
}

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
import tn.esprit.auction.delegate.GestionUserDelegate;
import java.util.ArrayList;
import java.util.List;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.ObjectProperty;

import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;

public class GestionManager extends JPanel {
	private JTable table;
	List<Manager> managers;
	AddManager addManager;
	//JScrollPane scrollPane;
	private JTextField tfName;
	private JTextField tfLogin;
	private JTextField passwordField;
	private JTextField tfEmail;
	Manager manager;
	JPanel panel;
	String name;

	/**
	 * Create the panel.
	 */
	public GestionManager() {
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 349, 297);
	
		managers =new ArrayList<Manager>();
		
		managers= GestionStaffDelegate.doFindAllManagers();
		scrollPane.setViewportView(table);
		
			
		

		JButton btnAdd = new JButton("add");
		btnAdd.setBounds(144, 368, 69, 23);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddManager addManager= new AddManager();
				scrollPane.setViewportView(addManager);
			}
		});
		
		JButton btnEdit = new JButton("edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.setUserName(tfLogin.getText());
				manager.setPassword(passwordField.getText());
				manager.setEmail(tfEmail.getText());
				manager.setFullName(tfName.getText());
				if (GestionStaffDelegate.doUpdateManager(manager))
				{JOptionPane.showMessageDialog(null, "ok...");
				tfLogin.setText("");
				passwordField.setText("");
				tfEmail.setText("");
				tfName.setText("");
				managers= GestionStaffDelegate.doFindAllManagers();
				initDataBindings();	
				}
				else {}
			}
		});
		btnEdit.setBounds(447, 368, 69, 23);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.setUserName(tfLogin.getText());
				manager.setPassword(passwordField.getText());
				manager.setEmail(tfEmail.getText());
				manager.setFullName(tfName.getText());
				if (GestionStaffDelegate.doDeleteManager(manager))
				{JOptionPane.showMessageDialog(null, "delete :) ...");
				tfLogin.setText("");
				passwordField.setText("");
				tfEmail.setText("");
				tfName.setText("");
				managers= GestionStaffDelegate.doFindAllManagers();
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
			 manager = managers.get(table.getSelectedRow());
			
				
						 tfLogin.setText(manager.getUserName());
						 passwordField.setText(manager.getPassword());
						tfEmail.setText(manager.getEmail());
						 tfName.setText(manager.getFullName());
			}
		});
		add(btnEdit);
		add(btnAdd);
		add(btnDelete);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(429, 60, 371, 297);
		add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "Edit manager", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		tfName = new JTextField();
		tfName.setBounds(124, 146, 86, 20);
		panel_1.add(tfName);
		tfName.setColumns(10);
		
		tfLogin = new JTextField();
		tfLogin.setBounds(124, 53, 86, 20);
		panel_1.add(tfLogin);
		tfLogin.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(124, 84, 86, 20);
		panel_1.add(passwordField);
		passwordField.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(124, 115, 86, 20);
		panel_1.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblLogin = new JLabel("login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLogin.setBounds(29, 56, 46, 14);
		panel_1.add(lblLogin);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(29, 87, 59, 14);
		panel_1.add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(29, 118, 46, 14);
		panel_1.add(lblEmail);
		
		JLabel lblName = new JLabel("name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(29, 149, 59, 14);
		panel_1.add(lblName);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GestionManager.class.getResource("/tn/esprit/auction/gui/admin/back1Config.jpg")));
		lblNewLabel.setBounds(10, 0, 1254, 800);
		add(lblNewLabel);
		initDataBindings();
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<Manager, List<Manager>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, managers, table);
		//
		BeanProperty<Manager, String> managerBeanProperty = BeanProperty.create("userName");
		jTableBinding.addColumnBinding(managerBeanProperty).setColumnName("name");
		//
		BeanProperty<Manager, String> managerBeanProperty_1 = BeanProperty.create("fullName");
		jTableBinding.addColumnBinding(managerBeanProperty_1).setColumnName("full name");
		//
		BeanProperty<Manager, String> managerBeanProperty_2 = BeanProperty.create("email");
		jTableBinding.addColumnBinding(managerBeanProperty_2).setColumnName("Email");
		//
		jTableBinding.bind();
	}
}

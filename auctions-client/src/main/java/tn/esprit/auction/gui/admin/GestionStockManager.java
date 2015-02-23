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

public class GestionStockManager extends JPanel {
	private JTable table;
	List<StockManager> stockManagers;
	AddStockManager addStockManager;
	//JScrollPane scrollPane;
	private JTextField tfName;
	private JTextField tfLogin;
	private JTextField passwordField;
	private JTextField tfEmail;
	StockManager stockManager;
	JPanel panel;
	private JTextField tfSearch;


	/**
	 * Create the panel.
	 */
	public GestionStockManager() {
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 354, 281);
		stockManagers =new ArrayList<StockManager>();
		stockManagers= GestionStaffDelegate.doFindAllStockManager();
		scrollPane.setViewportView(table);
	

		JButton btnAdd = new JButton("add");
		btnAdd.setBounds(144, 368, 69, 23);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStockManager addManager= new AddStockManager();
				scrollPane.setViewportView(addManager);
			}
		});
		
		JButton btnEdit = new JButton("edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockManager.setUserName(tfLogin.getText());
				stockManager.setPassword(passwordField.getText());
				stockManager.setEmail(tfEmail.getText());
				stockManager.setFullName(tfName.getText());
				if (GestionStaffDelegate.doUpdateStockManager(stockManager))
				{JOptionPane.showMessageDialog(null, "ok...");
				tfLogin.setText("");
				passwordField.setText("");
				tfEmail.setText("");
				tfName.setText("");
				stockManagers= GestionStaffDelegate.doFindAllStockManager();
				initDataBindings();	
				}
				else {}
			}
		});
		btnEdit.setBounds(447, 368, 69, 23);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockManager.setUserName(tfLogin.getText());
				stockManager.setPassword(passwordField.getText());
				stockManager.setEmail(tfEmail.getText());
				stockManager.setFullName(tfName.getText());
				if (GestionStaffDelegate.doDeleteStockManager(stockManager))
				{JOptionPane.showMessageDialog(null, "delete :) ...");
				tfLogin.setText("");
				passwordField.setText("");
				tfEmail.setText("");
				tfName.setText("");
				stockManagers= GestionStaffDelegate.doFindAllStockManager();
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
			 stockManager = stockManagers.get(table.getSelectedRow());
			
				
						 tfLogin.setText(stockManager.getUserName());
						 passwordField.setText(stockManager.getPassword());
						tfEmail.setText(stockManager.getEmail());
						 tfName.setText(stockManager.getFullName());
			}
		});
		add(btnEdit);
		add(btnAdd);
		add(btnDelete);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setForeground(Color.BLUE);
		panel_1.setBounds(429, 60, 352, 281);
		add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "Edit stockManager", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		lblLogin.setBounds(29, 56, 46, 14);
		panel_1.add(lblLogin);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(29, 87, 58, 14);
		panel_1.add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(29, 118, 46, 14);
		panel_1.add(lblEmail);
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(29, 149, 46, 14);
		panel_1.add(lblName);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GestionStockManager.class.getResource("/tn/esprit/auction/gui/admin/back1Config.jpg")));
		lblNewLabel.setBounds(10, 42, 1215, 756);
		add(lblNewLabel);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(57, 11, 86, 20);
		add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				
			}
		});
		btnNewButton.setBounds(175, 10, 89, 23);
		add(btnNewButton);
		initDataBindings();
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<StockManager, List<StockManager>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, stockManagers, table);
		//
		BeanProperty<StockManager, String> managerBeanProperty = BeanProperty.create("userName");
		jTableBinding.addColumnBinding(managerBeanProperty).setColumnName("name");
		//
		BeanProperty<StockManager, String> managerBeanProperty_1 = BeanProperty.create("fullName");
		jTableBinding.addColumnBinding(managerBeanProperty_1).setColumnName("full name");
		//
		BeanProperty<StockManager, String> managerBeanProperty_2 = BeanProperty.create("email");
		jTableBinding.addColumnBinding(managerBeanProperty_2).setColumnName("Email");
		//
		jTableBinding.bind();
	}
}

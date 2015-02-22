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

public class GestionBookKeeper extends JPanel {
	private JTable table;
	private JTextField tfSearch;
	List<BookKeeper> bookKeepers;
	AddBookKeeper addBookKeeper;
	//JScrollPane scrollPane;
	private JTextField tfName;
	private JTextField tfLogin;
	private JTextField passwordField;
	private JTextField tfEmail;
	BookKeeper bookKeeper;
	JPanel panel;


	/**
	 * Create the panel.
	 */
	public GestionBookKeeper() {
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 83, 354, 258);
		bookKeepers =new ArrayList<BookKeeper>();
		bookKeepers= GestionStaffDelegate.doFindAllBookKeeper();
		scrollPane.setViewportView(table);
	

		JButton btnAdd = new JButton("add");
		btnAdd.setBounds(144, 368, 69, 23);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookKeeper addBookKeeper= new AddBookKeeper();
				scrollPane.setViewportView(addBookKeeper);
			}
		});
		
		JButton btnEdit = new JButton("edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookKeeper.setUserName(tfLogin.getText());
				bookKeeper.setPassword(passwordField.getText());
				bookKeeper.setEmail(tfEmail.getText());
				bookKeeper.setFullName(tfName.getText());
				if (GestionStaffDelegate.doUpdateBookKeeper(bookKeeper))
				{JOptionPane.showMessageDialog(null, "ok...");
				tfLogin.setText("");
				passwordField.setText("");
				tfEmail.setText("");
				tfName.setText("");
				bookKeepers= GestionStaffDelegate.doFindAllBookKeeper();
				initDataBindings();	
				}
				else {}
			}
		});
		btnEdit.setBounds(447, 368, 69, 23);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookKeeper.setUserName(tfLogin.getText());
				bookKeeper.setPassword(passwordField.getText());
				bookKeeper.setEmail(tfEmail.getText());
				bookKeeper.setFullName(tfName.getText());
				if (GestionStaffDelegate.doDeleteBookKeeper(bookKeeper))
				{JOptionPane.showMessageDialog(null, "delete :) ...");
				tfLogin.setText("");
				passwordField.setText("");
				tfEmail.setText("");
				tfName.setText("");
				bookKeepers= GestionStaffDelegate.doFindAllBookKeeper();
				initDataBindings();	
				}
				else {}
			}
		});
		btnDelete.setBounds(280, 368, 79, 23);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(77, 25, 108, 14);
		tfSearch.setColumns(10);
		
		JLabel lblUsername = new JLabel("name:");
		lblUsername.setBounds(39, 25, 69, 14);
		
		JLabel lblRecherche = new JLabel("recherche");
		lblRecherche.setBounds(10, 0, 87, 22);
		lblRecherche.setForeground(Color.BLUE);
		lblRecherche.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 13));
		setLayout(null);
		
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			 bookKeeper = bookKeepers.get(table.getSelectedRow());
			
				
						 tfLogin.setText(bookKeeper.getUserName());
						 passwordField.setText(bookKeeper.getPassword());
						tfEmail.setText(bookKeeper.getEmail());
						 tfName.setText(bookKeeper.getFullName());
			}
		});
		add(btnEdit);
		add(btnAdd);
		add(btnDelete);
		add(lblUsername);
		add(tfSearch);
		add(lblRecherche);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(429, 60, 352, 256);
		add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "Edit book Keeper", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		lblPassword.setBounds(29, 87, 61, 14);
		panel_1.add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(29, 118, 46, 14);
		panel_1.add(lblEmail);
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(29, 149, 46, 14);
		panel_1.add(lblName);
		initDataBindings();
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<BookKeeper, List<BookKeeper>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, bookKeepers, table);
		//
		BeanProperty<BookKeeper, String> managerBeanProperty = BeanProperty.create("userName");
		jTableBinding.addColumnBinding(managerBeanProperty).setColumnName("name");
		//
		BeanProperty<BookKeeper, String> managerBeanProperty_1 = BeanProperty.create("fullName");
		jTableBinding.addColumnBinding(managerBeanProperty_1).setColumnName("full name");
		//
		BeanProperty<BookKeeper, String> managerBeanProperty_2 = BeanProperty.create("email");
		jTableBinding.addColumnBinding(managerBeanProperty_2).setColumnName("Email");
		//
		jTableBinding.bind();
	}
}

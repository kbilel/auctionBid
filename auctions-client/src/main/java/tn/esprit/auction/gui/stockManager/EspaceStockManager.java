package tn.esprit.auction.gui.stockManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.management.ManagementPermission;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;

import tn.esprit.auction.gui.authentification.Authentification;

public class EspaceStockManager extends JFrame {

	private JPanel contentPane;
	PanelAddProduct panelAddProduct;
	PanelManageProducts panelManageProducts;
	 JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EspaceStockManager frame = new EspaceStockManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EspaceStockManager() {
		setTitle("Espace Stock Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmManageProducts = new JMenuItem("Manage Products");
		mntmManageProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelManageProducts=new PanelManageProducts();
				scrollPane.setViewportView(panelManageProducts);
				
			}
		});
		menuBar.add(mntmManageProducts);
		
		JMenuItem mntmAddProduct = new JMenuItem("Add Product");
		mntmAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelAddProduct=new PanelAddProduct();
				scrollPane.setViewportView(panelAddProduct);
			}
		});
		menuBar.add(mntmAddProduct);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		 scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 821, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(243, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(876, 169, 199, 258);
		contentPane.add(panel);
	
	JLabel label = new JLabel("Manager");
	label.setForeground(new Color(0, 0, 139));
	label.setFont(new Font("Times New Roman", Font.BOLD, 20));
	label.setBounds(59, 11, 100, 41);
	panel.add(label);
	
	JLabel label_1 = new JLabel("User Name :");
	label_1.setBounds(20, 173, 69, 14);
	panel.add(label_1);
	
	JButton button = new JButton("Log out");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Authentification frame = new Authentification();
			frame.setVisible(true);
			setVisible(false);
		}
	});
	button.setBounds(68, 211, 121, 36);
	panel.add(button);
	
}
}

package tn.esprit.auction.gui.stockManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
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
import tn.esprit.auction.gui.client.EspaceClient;
import tn.esprit.auction.gui.client.HomeClient;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class EspaceStockManager extends JFrame {

	private JPanel contentPane;
	PanelAddProduct panelAddProduct;
	PanelManageProducts panelManageProducts;
	PanelStockManagerProfile panelStockManagerProfile;
	 JScrollPane scrollPane;
	 EspaceClient frame;

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
		setBounds(100, 100, 1800, 850);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1800, 50);
		setJMenuBar(menuBar);
		JMenuItem mntmProfile = new JMenuItem("");
		mntmProfile.setIcon(new ImageIcon(EspaceStockManager.class.getResource("/tn/esprit/auction/gui/client/boutonProfil.png")));
		mntmProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelStockManagerProfile=new PanelStockManagerProfile();
				scrollPane.setViewportView(panelStockManagerProfile);
				
			}
		});
		menuBar.add(mntmProfile);
		JMenuItem mntmManageProducts = new JMenuItem("");
		mntmManageProducts.setIcon(new ImageIcon(EspaceStockManager.class.getResource("/tn/esprit/auction/gui/client/boutonMnageProduct.png")));
		mntmManageProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelManageProducts=new PanelManageProducts();
				scrollPane.setViewportView(panelManageProducts);
				
			}
		});
		menuBar.add(mntmManageProducts);
		
		JMenuItem mntmAddProduct = new JMenuItem("");
		mntmAddProduct.setIcon(new ImageIcon(EspaceStockManager.class.getResource("/tn/esprit/auction/gui/client/boutonAddProduct.png")));
		mntmAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelAddProduct=new PanelAddProduct();
				scrollPane.setViewportView(panelAddProduct);
			}
		});
		menuBar.add(mntmAddProduct);
		contentPane = new JPanel();
		contentPane.setBounds(0, 50, 1800, 750);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		 scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel label = new JLabel(" Stock Manager:");
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
				HomeClient.userConnected  =null;
				EspaceClient	 frame=new EspaceClient();
					frame.setVisible(true);
			}
		});
		button.setBounds(68, 211, 121, 36);
		panel.add(button);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(EspaceStockManager.class.getResource(HomeClient.getUser().getImageUrl())));

		label_2.setBounds(79, 63, 100, 96);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel((String) null);
		label_3.setText(HomeClient.getUser().getUserName());

		label_3.setBounds(89, 173, 100, 14);
		panel.add(label_3);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 821, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(15)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(112)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EspaceStockManager.class.getResource("/tn/esprit/auction/gui/stockManager/stock.jpg")));
		scrollPane.setViewportView(lblNewLabel);
		contentPane.setLayout(gl_contentPane);
	
}
}

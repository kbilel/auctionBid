package tn.esprit.auction.gui.DeliveryMan;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JScrollPane;

import tn.esprit.auction.delegate.GestionOrderDelegate;
import tn.esprit.auction.domain.Order;
import tn.esprit.auction.gui.client.EspaceClient;
import tn.esprit.auction.gui.client.HomeClient;
import tn.esprit.auction.gui.stockManager.EspaceStockManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import java.awt.SystemColor;

import javax.swing.JTable;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import javax.swing.border.BevelBorder;

public class EspaceDeliveryMan extends JFrame {

	private JPanel contentPane;
	JScrollPane 	 scrollPane = new JScrollPane();
	PanelShowOrder panelShowOrder;
	PanelAjoutOrder panelAjoutOrder=new PanelAjoutOrder();
	PanelProfile panelProfile=new PanelProfile();
	// List<Order>orderForDeliveryMan;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EspaceDeliveryMan frame = new EspaceDeliveryMan();
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
	public EspaceDeliveryMan() {
	
		
	
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1056, 660);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAdd = new JMenu("Orders");
		mnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelShowOrder=new PanelShowOrder();
			
				scrollPane.setViewportView(panelShowOrder);
			}
		});
		
		menuBar.add(mnAdd);
		
		JMenu mnSho = new JMenu("Add order");
		mnSho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 panelAjoutOrder=new PanelAjoutOrder();
				scrollPane.setViewportView(panelAjoutOrder);
			}
		});
		menuBar.add(mnSho);
		
		JMenu mnProfile = new JMenu("Profile");
		mnProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane.setViewportView(panelProfile);
			}
		});
		menuBar.add(mnProfile);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(53, 74, 748, 458);

		contentPane.add(scrollPane);
		
		JLabel lblDeliveryMan = new JLabel("Delivery Man");
		lblDeliveryMan.setBounds(322, 21, 316, 34);
		lblDeliveryMan.setFont(new Font("Rockwell Condensed", Font.ITALIC, 39));
		lblDeliveryMan.setForeground(new Color(255, 102, 51));
		contentPane.add(lblDeliveryMan);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(831, 144, 199, 258);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Manager");
		label.setForeground(new Color(0, 0, 139));
		label.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label.setBounds(59, 11, 100, 41);
		panel.add(label);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setBounds(10, 186, 69, 14);
		panel.add(lblUsername);
		
		JButton button = new JButton("Log out");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EspaceClient frame=new EspaceClient();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(68, 211, 121, 36);
		panel.add(button);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(EspaceDeliveryMan.class.getResource(HomeClient.getUser().getImageUrl())));
		label_2.setBounds(38, 63, 141, 96);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel((String) null);
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		label_3.setText(" "+ HomeClient.getUser().getUserName());
		label_3.setBounds(89, 184, 100, 14);
		panel.add(label_3);
		initDataBindings();
	
		
		
	}
	protected void initDataBindings() {

	}
}

package tn.esprit.auction.gui.DeliveryMan;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JScrollPane;

import tn.esprit.auction.domain.Order;

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

public class EspaceDeliveryMan extends JFrame {

	private JPanel contentPane;
	JScrollPane 	 scrollPane = new JScrollPane();
	PanelShowOrder panelShowOrder;
	PanelAjoutOrder panelAjoutOrder=new PanelAjoutOrder();
	
	

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
		setBounds(100, 100, 882, 602);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAdd = new JMenu("show");
		mnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelShowOrder=new PanelShowOrder();
			
				scrollPane.setViewportView(panelShowOrder);
			}
		});
		
		menuBar.add(mnAdd);
		
		JMenu mnSho = new JMenu("ajout");
		mnSho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 panelAjoutOrder=new PanelAjoutOrder();
				scrollPane.setViewportView(panelAjoutOrder);
			}
		});
		menuBar.add(mnSho);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		scrollPane.setBounds(134, 74, 554, 429);
		contentPane.add(scrollPane);
		
		JLabel lblDeliveryMan = new JLabel("Delivery Man");
		lblDeliveryMan.setFont(new Font("Rockwell Condensed", Font.ITALIC, 39));
		lblDeliveryMan.setForeground(new Color(255, 102, 51));
		lblDeliveryMan.setBounds(322, 21, 316, 34);
		contentPane.add(lblDeliveryMan);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(736, 480, 89, 23);
		contentPane.add(btnLogout);
		
		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.textHighlight);
		panel.setBorder(new TitledBorder(null, "DeliveryMan", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(710, 179, 146, 272);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(10, 223, 65, 14);
		panel.add(lblNewLabel);
	
		
		
	}

}

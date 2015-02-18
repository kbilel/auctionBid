package tn.esprit.auction.gui.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import tn.esprit.auction.delegate.GestionUserDelegate;
import tn.esprit.auction.domain.Client;
import tn.esprit.auction.gui.authentification.Authentification;
import tn.esprit.auction.gui.authentification.HomeAllUsers;
import tn.esprit.auction.gui.client.SubscribingSpace;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JScrollPane;

public class EspaceAdmin extends JFrame {

	private JPanel contentPane;
	private JTable tableClients;
	JLabel labelAdresse;
	JLabel labelImage;
	JLabel labelname;
	JLabel labelUsername;
	JLabel labelPassword;
	JLabel labelEmail;
	JLabel labelTokens;
	Client client=null;
GestionClient gestionClient;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EspaceAdmin frame = new EspaceAdmin();
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
	public EspaceAdmin() {
		gestionClient=new GestionClient();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1151, 696);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 39, 1135, 608);
		contentPane.add(scrollPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1135, 41);
		contentPane.add(menuBar);
		
		JMenu mnHome = new JMenu("Home");
		menuBar.add(mnHome);
		
		JMenu mnManager = new JMenu("Manager");
		menuBar.add(mnManager);
		
		JMenu mnStockManager = new JMenu("Stock Manager");
		menuBar.add(mnStockManager);
		
		JMenu mnDeliveryMan = new JMenu("Delivery Man");
		menuBar.add(mnDeliveryMan);
		
		JMenu mnClient = new JMenu("Client");
		mnClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane.setViewportView(gestionClient);
				System.out.println("otttk");
			}
		});
		
		menuBar.add(mnClient);
		
		
		
		JPanel panel = new JPanel();



		panel.setBounds(0, 0, 424, 262);


			}
}

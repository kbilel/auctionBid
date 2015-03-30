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
import javax.swing.JMenuItem;

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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 1800, 800);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 50, 1800, 800);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(new HomeAdmin(scrollPane));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1800, 50);
		contentPane.add(menuBar);
		
		JMenu mnHome = new JMenu("");
		mnHome.setIcon(new ImageIcon(EspaceAdmin.class.getResource("/tn/esprit/auction/gui/client/boutonHome.png")));
		mnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane.setViewportView(new HomeAdmin(scrollPane));
			}
		});
		menuBar.add(mnHome);
		

		JMenu mnManager = new JMenu("");
mnManager.setIcon(new ImageIcon(EspaceAdmin.class.getResource("/tn/esprit/auction/gui/client/ManagerBouton.png")));

		mnManager.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionManager gestionManager=new GestionManager();
				scrollPane.setViewportView(gestionManager);
			}
		});
	
	menuBar.add(mnManager);
		

		JMenu mnStockManager = new JMenu("");
		mnStockManager.setIcon(new ImageIcon(EspaceAdmin.class.getResource("/tn/esprit/auction/gui/client/boutonStockManager.png")));

		mnStockManager.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionStockManager gestionStockManager=new GestionStockManager();
				scrollPane.setViewportView(gestionStockManager);
			}
		});
		

		menuBar.add(mnStockManager);
		

		JMenu mnDeliveryMan = new JMenu("");
		mnDeliveryMan.setIcon(new ImageIcon(EspaceAdmin.class.getResource("/tn/esprit/auction/gui/client/boutonDeliveryMan.png")));

		mnDeliveryMan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionDeliveryMan gestionDeliveryMan=new GestionDeliveryMan();
				scrollPane.setViewportView(gestionDeliveryMan);
			}
		});
		
	menuBar.add(mnDeliveryMan);
		
		JMenu mnClient = new JMenu("");
		mnClient.setIcon(new ImageIcon(EspaceAdmin.class.getResource("/tn/esprit/auction/gui/client/boutonClients.png")));
		mnClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane.setViewportView(new AdminClient());
				System.out.println("otttk");
			}
		});
		
		JMenu mnBookKeeper = new JMenu("");
		mnBookKeeper.setIcon(new ImageIcon(EspaceAdmin.class.getResource("/tn/esprit/auction/gui/client/boutonBook.png")));
		mnBookKeeper.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionBookKeeper gestionBookKeeper=new GestionBookKeeper();
				scrollPane.setViewportView(gestionBookKeeper);
			}
		});
		
		JMenu mnQuiz = new JMenu("");
		mnQuiz.setIcon(new ImageIcon(EspaceAdmin.class.getResource("/tn/esprit/auction/gui/client/boutonQuiz.png")));
		menuBar.add(mnQuiz);
		
		JMenu mnQuestion = new JMenu("");
		mnQuestion.setIcon(new ImageIcon(EspaceAdmin.class.getResource("/tn/esprit/auction/gui/client/boutonQuestion.png")));
		mnQuiz.add(mnQuestion);
		
		JMenuItem mntmAdd = new JMenuItem("");
		mntmAdd.setIcon(new ImageIcon(EspaceAdmin.class.getResource("/tn/esprit/auction/gui/client/boutonAddQuestion.png")));
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setViewportView(new QuestionQUIZ(scrollPane));
			}
		});
		mnQuestion.add(mntmAdd);
		
		JMenuItem mntmDelete = new JMenuItem("");
		mntmDelete.setIcon(new ImageIcon(EspaceAdmin.class.getResource("/tn/esprit/auction/gui/client/boutonDeleteQuestion.png")));
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setViewportView(new ListQuestionPanel());
			}
		});
		mnQuestion.add(mntmDelete);
		menuBar.add(mnBookKeeper);
		
		menuBar.add(mnClient);
		
		JMenu mnConfiguration = new JMenu("");
		mnConfiguration.setIcon(new ImageIcon(EspaceAdmin.class.getResource("/tn/esprit/auction/gui/client/boutonConfiguration.png")));
		mnConfiguration.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane.setViewportView(new ConfigurationPanel(scrollPane));
			}
		});
		menuBar.add(mnConfiguration);
		
		
		
		JPanel panel = new JPanel();



		panel.setBounds(0, 0, 424, 262);


			}
}

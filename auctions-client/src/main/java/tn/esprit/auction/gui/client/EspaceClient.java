package tn.esprit.auction.gui.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.SystemColor;
import java.awt.Color;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPasswordField;

import tn.esprit.auction.delegate.GestionAuctionDelegate;
import tn.esprit.auction.delegate.GestionConfigurationDelegate;
import tn.esprit.auction.delegate.GestionUserDelegate;
import tn.esprit.auction.domain.Auction;
import tn.esprit.auction.domain.Client;
import tn.esprit.auction.domain.Configuration;
import tn.esprit.auction.domain.DutchAuction;
import tn.esprit.auction.domain.EnglishAuction;
import tn.esprit.auction.domain.NegociatedAuction;
import tn.esprit.auction.domain.User;
import tn.esprit.auction.domain.YankeeAuction;
import tn.esprit.auction.gui.authentification.Authentification;
import tn.esprit.auction.gui.authentification.HomeAllUsers;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EspaceClient extends JFrame {
User userConnected;
Client client;
private String pathImg;
private String imageUserPath;
byte[] imageUserByte=null;
	private JPanel contentPane;
	private JPasswordField passwordFieldEdit;
	private JTextField tfFullnameEdit;
	private JTextField tfLoginEdit;
	private JTextField tfEmailEdit;
	private JTextField tfAdresseEdit;
	private JTextField tfPathImageUser;
	ProfilClient profileClient=new ProfilClient();
	DefaultPieDataset dataset = null;
    JFreeChart graphe = null;
   ChartPanel cp = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EspaceClient frame = new EspaceClient();
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
	public EspaceClient() {
		client=new Client();
		userConnected=Authentification.getUser();
		       if(userConnected==null)
			   userConnected=SubscribingSpace.getUser();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1158, 850);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 JPanel panel = new JPanel();
		panel.setBounds(10, 11, 1122, 790);
		contentPane.add(panel);
		panel.setLayout(null);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1122, 790);
		panel.add(scrollPane);
		
		JMenuBar menuBar = new JMenuBar();
		scrollPane.setColumnHeaderView(menuBar);
		
		JMenu mnHome = new JMenu("home");
		menuBar.add(mnHome);
		
		JMenu mnAuctions = new JMenu("Auctions");
		menuBar.add(mnAuctions);
		
		JMenu mnProducts = new JMenu("Products");
		menuBar.add(mnProducts);
		
		JMenu mnStatistic = new JMenu("Statistic");
		menuBar.add(mnStatistic);
		
		JMenu mnAboutUs = new JMenu("About us");
		menuBar.add(mnAboutUs);
		final JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane.setViewportView(scrollPane_1);
		
		JMenu menuProfil = new JMenu("profil");
		menuProfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			ProfilClient	profil = new ProfilClient();
			scrollPane_1.setViewportView(profil);
				
				
			}
		});
		
		menuBar.add(menuProfil);
		
		
		
		
		/********Stat*******/
		 List<Auction> auctions=new ArrayList<Auction>();
		 auctions=GestionAuctionDelegate.doFindAllAuctions();
		 Integer englishAuction=0;
		 Integer yankeeAuction=0;
		 Integer dutchAuction=0;
		 Integer negocietedAuction=0;
		 Integer auction5=0;
		 
       for (Auction auction : auctions) {
           if (auction instanceof EnglishAuction) {
               englishAuction++;
               
           } else if (auction instanceof YankeeAuction) {
           	yankeeAuction++;
              
           } else if (auction instanceof DutchAuction) {
           	dutchAuction++;
           } else if (auction instanceof NegociatedAuction) {
           	negocietedAuction++;
           } 
           //else if (auction instanceof YankeeAuction) {
             //  auction5++;
          // System.out.println(england);}
             
           

       }
       dataset = new DefaultPieDataset();
       dataset.setValue("English Auction", englishAuction);
       dataset.setValue("Dutch Auction", yankeeAuction);
       dataset.setValue("Yankee Auction", dutchAuction);
       dataset.setValue("Negocieted Auction",negocietedAuction);
       dataset.setValue("auction5", auction5);
       graphe = ChartFactory.createPieChart3D("Pie Chart Auction's Categories", dataset,true, true, true);
      // tabbedPane.addTab("New tab", null, cp, null);
		/********Stat*******/
		
	}
}

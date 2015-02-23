package tn.esprit.auction.gui.client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RefineryUtilities;

import tn.esprit.auction.delegate.GestionAuctionDelegate;
import tn.esprit.auction.delegate.GestionProductDelegate;
import tn.esprit.auction.delegate.GestionQuestionDelegate;
import tn.esprit.auction.domain.Auction;
import tn.esprit.auction.domain.Client;
import tn.esprit.auction.domain.DutchAuction;
import tn.esprit.auction.domain.EnglishAuction;
import tn.esprit.auction.domain.NegociatedAuction;
import tn.esprit.auction.domain.Product;
import tn.esprit.auction.domain.Question;
import tn.esprit.auction.domain.User;
import tn.esprit.auction.domain.YankeeAuction;
import tn.esprit.auction.gui.authentification.Authentification;
import tn.esprit.auction.gui.stockManager.PanelAddProduct;

import javax.swing.JMenuItem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Toolkit;

public class EspaceClient extends JFrame {
	User userConnected;
	Client client;
	private String pathImg;
	private String imageUserPath;
	byte[] imageUserByte = null;
	private JPanel contentPane;
	private JPasswordField passwordFieldEdit;
	private JTextField tfFullnameEdit;
	private JTextField tfLoginEdit;
	private JTextField tfEmailEdit;
	private JTextField tfAdresseEdit;
	private JTextField tfPathImageUser;



	
	DefaultPieDataset dataset = null;
	JFreeChart graphe = null;
	JScrollPane scrollPane;
	ChartPanel cp = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EspaceClient frame = new EspaceClient();
					RefineryUtilities.centerFrameOnScreen(frame);
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(EspaceClient.class.getResource("/tn/esprit/auction/gui/authentification/bid1.gif")));
		client = new Client();
		final List<Auction> auctions=GestionAuctionDelegate.doFindAllAuctions();
		final List<Product> products=GestionProductDelegate.doFindAllProducts();
		
		userConnected = HomeClient.userConnected;
		if (userConnected == null)
			userConnected = SubscribingSpace.getUser();
		JMenu mnSubscribe = new JMenu("");
		mnSubscribe.setIcon(new ImageIcon(EspaceClient.class.getResource("/tn/esprit/auction/gui/client/boutonSubscribe.png")));
		if(userConnected!=null)
		{
			mnSubscribe.setVisible(false);
			
		}else 
		{
			mnSubscribe.setVisible(true);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1800, 850);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1800, 50);
		contentPane.add(menuBar);
		
		JMenu mnProfil = new JMenu("");
		mnProfil.setIcon(new ImageIcon(EspaceClient.class.getResource("/tn/esprit/auction/gui/client/boutonProfil.png")));
		mnProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setViewportView(new PanelProfil());
				
			}
		});
		
		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setIcon(new ImageIcon(EspaceClient.class.getResource("/tn/esprit/auction/gui/client/boutonHome.png")));
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane.setViewportView(new HomeClient());
				
			}
		});
		menuBar.add(mnNewMenu);
		
		JMenu mnAuctions = new JMenu("");
		mnAuctions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane.setViewportView(new PanelAuctionList());
			}
		});
		mnAuctions.setIcon(new ImageIcon(EspaceClient.class.getResource("/tn/esprit/auction/gui/client/boutonAuction.png")));
		menuBar.add(mnAuctions);
		

		JMenu mnProducts = new JMenu("Products");
		mnProducts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane.setViewportView(new PanelProductList());
			}
		});
		

		menuBar.add(mnProducts);
		
		JMenu mnStatistic = new JMenu("");
		mnStatistic.setIcon(new ImageIcon(EspaceClient.class.getResource("/tn/esprit/auction/gui/client/boutonStat.png")));
		mnStatistic.setSelectedIcon(new ImageIcon(EspaceClient.class.getResource("/tn/esprit/auction/gui/client/boutonStat.png")));
		menuBar.add(mnStatistic);
		
		JMenu mnProductByCategories = new JMenu("Product by Category");
		mnStatistic.add(mnProductByCategories);
		
		JMenuItem mntmPieChart = new JMenuItem("Pie chart");
		mntmPieChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(products!=null)
				scrollPane.setViewportView(new StatisticProductCategories());
				else
					JOptionPane.showMessageDialog(contentPane, "there is no product");
				System.out.println("otttk");
			}
		});
		mnProductByCategories.add(mntmPieChart);
		
		JMenuItem mntmBarChart = new JMenuItem("Bar chart");
		mntmBarChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(products!=null)
				scrollPane.setViewportView(new StatisticProductCategoriesBar());
				else
					JOptionPane.showMessageDialog(contentPane, "there is no product");
				
				
			}
		});
		mnProductByCategories.add(mntmBarChart);
		
		JMenu mnAuctionByCategory = new JMenu("Auction by Category");
		mnStatistic.add(mnAuctionByCategory);
		
		JMenuItem mntmPieChart_1 = new JMenuItem("Pie Chart");
		mntmPieChart_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(auctions!=null)
				scrollPane.setViewportView(new StatisticAuctionCategories());
				else
					JOptionPane.showMessageDialog(contentPane, "there is no auction");
				System.out.println("otttk");
			}
		});
		mnAuctionByCategory.add(mntmPieChart_1);
		
		JMenuItem mntmBarChart_1 = new JMenuItem("Bar chart");
		mntmBarChart_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(auctions!=null)
				scrollPane.setViewportView(new StatisticAuctionCategoryBar());
				else
					JOptionPane.showMessageDialog(contentPane, "there is no auction");
				System.out.println("otttk Year");
			}
		});
		mnAuctionByCategory.add(mntmBarChart_1);
		
		JMenu mnAuctionByYear = new JMenu("Auction by year");
		mnStatistic.add(mnAuctionByYear);
		
		JMenuItem mntmPieChart_2 = new JMenuItem("Pie chart");
		mntmPieChart_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(auctions!=null)
				scrollPane.setViewportView(new StatisticAuctionYear());
				else
				JOptionPane.showMessageDialog(contentPane, "there is no auction");
				System.out.println("otttk Year");
			}
		});
		mnAuctionByYear.add(mntmPieChart_2);
		
		JMenuItem mntmBarChart_2 = new JMenuItem("Bar chart");
		mntmBarChart_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(auctions!=null)
				scrollPane.setViewportView(new StatisticAuctionYearBar());
				else
					JOptionPane.showMessageDialog(contentPane, "there is no auction");
					
				System.out.println("otttk Year");
			}
		});
		mnAuctionByYear.add(mntmBarChart_2);
		menuBar.add(mnProfil);
		
		JMenuItem mntmGestionProfil = new JMenuItem("Gestion Profil");
		mntmGestionProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				scrollPane.setViewportView(new PanelProfil());
				System.out.println("otttk");
			}
		});
		mnProfil.add(mntmGestionProfil);
		
		
		mnSubscribe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane.setViewportView(new SubscribingPanel());
				
				
			}
		});
		menuBar.add(mnSubscribe);
		
		JMenu mnAboutUs = new JMenu("");
		mnAboutUs.setIcon(new ImageIcon(EspaceClient.class.getResource("/tn/esprit/auction/gui/client/boutonAboutUs.png")));
		menuBar.add(mnAboutUs);
		
		 scrollPane = new JScrollPane();
		 scrollPane.setBounds(0, 50, 1800, 750);
		contentPane.add(scrollPane);
		HomeClient homeClient = new HomeClient();
		scrollPane.setViewportView(homeClient);

		/******** Stat *******/
		

	}
}

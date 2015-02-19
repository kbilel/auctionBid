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
import tn.esprit.auction.domain.Auction;
import tn.esprit.auction.domain.Client;
import tn.esprit.auction.domain.DutchAuction;
import tn.esprit.auction.domain.EnglishAuction;
import tn.esprit.auction.domain.NegociatedAuction;
import tn.esprit.auction.domain.User;
import tn.esprit.auction.domain.YankeeAuction;
import tn.esprit.auction.gui.authentification.Authentification;

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

	PanelProfil panelProfil;
	StatisticAuctionCategories statisticAuctions;
	StatisticProductCategories statisticProducts;
	StatisticAuctionYear statisticAuctionYear;

	StatisticProductCategoriesBar statisticProductsBar;
	StatisticAuctionCategoryBar statisticAuctionCategoryBar;
	StatisticAuctionYearBar statisticAuctionYearBar;
	
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
		statisticAuctions=new StatisticAuctionCategories();
		statisticProducts=new StatisticProductCategories();
		statisticAuctionYear=new StatisticAuctionYear();
		statisticProductsBar= new StatisticProductCategoriesBar() ;
		statisticAuctionCategoryBar= new StatisticAuctionCategoryBar() ;
		statisticAuctionYearBar= new StatisticAuctionYearBar() ;
		panelProfil=new PanelProfil();
		userConnected = HomeClient.userConnected;
		if (userConnected == null)
			userConnected = SubscribingSpace.getUser();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1158, 850);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1222, 21);
		contentPane.add(menuBar);
		
		JMenu mnProfil = new JMenu("Profil");
		mnProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		JMenu mnNewMenu = new JMenu("home");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane.setViewportView(new HomeClient());
				
			}
		});
		menuBar.add(mnNewMenu);
		
		JMenu mnAuctions = new JMenu("Auctions");
		menuBar.add(mnAuctions);
		
		JMenu mnProducts = new JMenu("Products");
		menuBar.add(mnProducts);
		
		JMenu mnStatistic = new JMenu("Statistic");
		menuBar.add(mnStatistic);
		
		JMenu mnProductByCategories = new JMenu("Product by Category");
		mnStatistic.add(mnProductByCategories);
		
		JMenuItem mntmPieChart = new JMenuItem("Pie chart");
		mntmPieChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setViewportView(statisticProducts);
				System.out.println("otttk");
			}
		});
		mnProductByCategories.add(mntmPieChart);
		
		JMenuItem mntmBarChart = new JMenuItem("Bar chart");
		mntmBarChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(statisticProductsBar==null)
					System.out.println("nullll");
				scrollPane.setViewportView(statisticProductsBar);
				System.out.println("otttk Bar Product");
				
			}
		});
		mnProductByCategories.add(mntmBarChart);
		
		JMenu mnAuctionByCategory = new JMenu("Auction by Category");
		mnStatistic.add(mnAuctionByCategory);
		
		JMenuItem mntmPieChart_1 = new JMenuItem("Pie Chart");
		mntmPieChart_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setViewportView(statisticAuctions);
				System.out.println("otttk");
			}
		});
		mnAuctionByCategory.add(mntmPieChart_1);
		
		JMenuItem mntmBarChart_1 = new JMenuItem("Bar chart");
		mntmBarChart_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setViewportView(statisticAuctionCategoryBar);
				System.out.println("otttk Year");
			}
		});
		mnAuctionByCategory.add(mntmBarChart_1);
		
		JMenu mnAuctionByYear = new JMenu("Auction by year");
		mnStatistic.add(mnAuctionByYear);
		
		JMenuItem mntmPieChart_2 = new JMenuItem("Pie chart");
		mntmPieChart_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				scrollPane.setViewportView(statisticAuctionYear);
				System.out.println("otttk Year");
			}
		});
		mnAuctionByYear.add(mntmPieChart_2);
		
		JMenuItem mntmBarChart_2 = new JMenuItem("Bar chart");
		mntmBarChart_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setViewportView(statisticAuctionYearBar);
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
		
		JMenu mnSubscribe = new JMenu("subscribe");
		if(userConnected!=null)
		{
			
			
		}else 
		{
			
		}
		mnSubscribe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SubscribingSpace().setVisible(true);
				
			}
		});
		menuBar.add(mnSubscribe);
		
		JMenu mnAboutUs = new JMenu("About us");
		menuBar.add(mnAboutUs);
		
		 scrollPane = new JScrollPane();
		 scrollPane.setBounds(0, 21, 1142, 791);
		contentPane.add(scrollPane);
		HomeClient homeClient = new HomeClient();
		scrollPane.setViewportView(homeClient);

		/******** Stat *******/
		List<Auction> auctions = new ArrayList<Auction>();
		auctions = GestionAuctionDelegate.doFindAllAuctions();
		Integer englishAuction = 0;
		Integer yankeeAuction = 0;
		Integer dutchAuction = 0;
		Integer negocietedAuction = 0;
		Integer auction5 = 0;

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
			// else if (auction instanceof YankeeAuction) {
			// auction5++;
			// System.out.println(england);}

		}
		dataset = new DefaultPieDataset();
		dataset.setValue("English Auction", englishAuction);
		dataset.setValue("Dutch Auction", yankeeAuction);
		dataset.setValue("Yankee Auction", dutchAuction);
		dataset.setValue("Negocieted Auction", negocietedAuction);
		dataset.setValue("auction5", auction5);
		graphe = ChartFactory.createPieChart3D(
				"Pie Chart Auction's Categories", dataset, true, true, true);
		// tabbedPane.addTab("New tab", null, cp, null);
		/******** Stat *******/

	}
}

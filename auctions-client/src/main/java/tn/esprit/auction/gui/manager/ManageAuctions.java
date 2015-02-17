package tn.esprit.auction.gui.manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.Insets;
import java.awt.Font;

import javax.swing.JLabel;

//import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

import tn.esprit.auction.domain.EnglishAuction;
import tn.esprit.auction.gui.authentification.Authentification;

import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

public class ManageAuctions extends JFrame {

	private JPanel contentPane;
	List<EnglishAuction> englishAuctions; 
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageAuctions frame = new ManageAuctions();
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
	public ManageAuctions() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManageAuctions.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		setTitle("Auction");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 494);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setToolTipText("");
		menuBar.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 16));
		setJMenuBar(menuBar);
		
		JMenuItem mntmHome = new JMenuItem("Home");
		mntmHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EspaceManager espaceManager=new EspaceManager();
				espaceManager.setVisible(true);
				setVisible(false);
			}
		});
		menuBar.add(mntmHome);
		
		JMenuItem mntmAuctions = new JMenuItem("Auctions");
		mntmAuctions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		menuBar.add(mntmAuctions);
		
		JMenuItem mntmProducts = new JMenuItem("Products");
		menuBar.add(mntmProducts);
		
		JMenuItem mntmAboutUs = new JMenuItem("About us");
		menuBar.add(mntmAboutUs);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 145, 875, 35);
		
		JMenuBar menuBar_1 = new JMenuBar();
		scrollPane.setViewportView(menuBar_1);
		menuBar_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JMenuItem mntmMyProfile = new JMenuItem("My Profile");
		menuBar_1.add(mntmMyProfile);
		
		JMenuItem mntmMessage = new JMenuItem("Message");
		menuBar_1.add(mntmMessage);
		
		JMenuItem mntmManageAuctionss = new JMenuItem("Manage Auctions");
		mntmManageAuctionss.setSelected(true);
		
		menuBar_1.add(mntmManageAuctionss);
		
		JMenuItem mntmManageOrders = new JMenuItem("Manage Order");
		menuBar_1.add(mntmManageOrders);
		
		JPanel panel = new JPanel();
		panel.setBounds(672, 187, 199, 258);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setLayout(null);
		
		JLabel lblManager = new JLabel("Manager");
		lblManager.setForeground(new Color(0, 0, 139));
		lblManager.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblManager.setBounds(59, 11, 100, 41);
		panel.add(lblManager);
		
		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setBounds(20, 173, 69, 14);
		panel.add(lblUserName);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Authentification frame = new Authentification();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnLogOut.setIcon(new ImageIcon(ManageAuctions.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
		btnLogOut.setBounds(68, 211, 121, 36);
		panel.add(btnLogOut);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(32, 5, 120, 116);
		lblNewLabel.setIcon(new ImageIcon(ManageAuctions.class.getResource("/tn/esprit/auction/gui/manager/bid.png")));
		
		JLabel lblISubscribe = new JLabel("Manager  Space");
		lblISubscribe.setBounds(251, 41, 659, 74);
		lblISubscribe.setBackground(Color.WHITE);
		lblISubscribe.setForeground(Color.RED);
		lblISubscribe.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 40));
		
		JLabel lblEnglishAuctionsTable = new JLabel("English Auctions Table :");
		lblEnglishAuctionsTable.setBounds(235, 199, 249, 41);
		lblEnglishAuctionsTable.setForeground(new Color(0, 0, 139));
		lblEnglishAuctionsTable.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.setLayout(null);
		contentPane.add(scrollPane);
		contentPane.add(panel);
		contentPane.add(lblNewLabel);
		contentPane.add(lblISubscribe);
		contentPane.add(lblEnglishAuctionsTable);
		
		JButton btnNewButton = new JButton("Update selected Auction");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(5, 385, 190, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add new Auction");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConvertProductToAuction frame = new ConvertProductToAuction();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(5, 362, 190, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblSelectAnAuction_1 = new JLabel("Select an auction to update and then click the button !");
		lblSelectAnAuction_1.setForeground(new Color(255, 140, 0));
		lblSelectAnAuction_1.setBounds(205, 389, 454, 14);
		contentPane.add(lblSelectAnAuction_1);
		
		JLabel lblClickHereTo = new JLabel("Click here to convert a Product to an Auction !");
		lblClickHereTo.setForeground(Color.GREEN);
		lblClickHereTo.setBounds(205, 362, 454, 14);
		contentPane.add(lblClickHereTo);
		
		JLabel label = new JLabel("Select an auction to delete and then click the button !");
		label.setForeground(Color.RED);
		label.setBounds(205, 414, 454, 14);
		contentPane.add(label);
		
		JButton button = new JButton("Delete selected Auction");
		button.setBounds(5, 408, 190, 23);
		contentPane.add(button);
		
		table = new JTable();
		table.setBounds(32, 237, 584, 68);
		contentPane.add(table);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<EnglishAuction, List<EnglishAuction>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, englishAuctions, table);
		//
		BeanProperty<EnglishAuction, Integer> englishAuctionBeanProperty = BeanProperty.create("auctionStartingPrice");
		jTableBinding.addColumnBinding(englishAuctionBeanProperty).setColumnName("Starting Price").setEditable(false);
		//
		BeanProperty<EnglishAuction, Integer> englishAuctionBeanProperty_1 = BeanProperty.create("id");
		jTableBinding.addColumnBinding(englishAuctionBeanProperty_1).setColumnName("Id").setEditable(false);
		//
		jTableBinding.bind();
	}
}

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

import tn.esprit.auction.gui.authentification.Authentification;

import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import java.awt.List;

public class EspaceDelivryMana extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EspaceDelivryMana frame = new EspaceDelivryMana();
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
	public EspaceDelivryMana() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EspaceDelivryMana.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
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
		
		JMenuItem mntmMessage = new JMenuItem("Message(5)");
		menuBar_1.add(mntmMessage);
		
		JMenuItem mntmManageOrders = new JMenuItem(" Order (2)");
		mntmManageOrders.setForeground(new Color(0, 128, 0));
		mntmManageOrders.setBackground(new Color(34, 139, 34));
		menuBar_1.add(mntmManageOrders);
		
		JPanel panel = new JPanel();
		panel.setBounds(681, 174, 199, 258);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setLayout(null);
		
		JLabel lblManager = new JLabel("DelivryMan Space");
		lblManager.setForeground(new Color(0, 0, 139));
		lblManager.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblManager.setBounds(20, 11, 169, 41);
		panel.add(lblManager);
		
		JLabel lblUserName = new JLabel("Username : Bilel");
		lblUserName.setForeground(SystemColor.activeCaptionText);
		lblUserName.setBounds(23, 130, 109, 14);
		panel.add(lblUserName);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Authentification frame = new Authentification();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnLogOut.setIcon(new ImageIcon(EspaceDelivryMana.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
		btnLogOut.setBounds(68, 211, 121, 36);
		panel.add(btnLogOut);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(32, 5, 120, 116);
		lblNewLabel.setIcon(new ImageIcon(EspaceDelivryMana.class.getResource("/tn/esprit/auction/gui/manager/bid.png")));
		
		JLabel lblISubscribe = new JLabel("Manager  Space");
		lblISubscribe.setBounds(251, 41, 659, 74);
		lblISubscribe.setBackground(Color.WHITE);
		lblISubscribe.setForeground(Color.RED);
		lblISubscribe.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 40));
		
		JLabel lblEnglishAuctionsTable = new JLabel("List of Clients orders");
		lblEnglishAuctionsTable.setBounds(235, 199, 249, 41);
		lblEnglishAuctionsTable.setForeground(new Color(0, 0, 139));
		lblEnglishAuctionsTable.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.setLayout(null);
		contentPane.add(scrollPane);
		contentPane.add(panel);
		contentPane.add(lblNewLabel);
		contentPane.add(lblISubscribe);
		contentPane.add(lblEnglishAuctionsTable);
		
		String[] columnNames = {"First Name",
				"Last Name",
				"Sport",
				"# of Years",
				"Vegetarian"};

				Object[][] data = {
				{"Kathy", "Smith","Snowboarding", new Integer(5), new Boolean(false)},
				{"John", "Doe", "Rowing", new Integer(3), new Boolean(true)},
				{"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)},
				{"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)},
				{"Joe", "Brown", "Pool", new Integer(10), new Boolean(false)}
				};	
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(77, 263, 533, 118);
		contentPane.add(scrollPane_1);

			
		
		table = new JTable(data, columnNames);
		scrollPane_1.setViewportView(table);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(0, 139, 139));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "auction", "143", "ariana cit\u00E9 nasim", "delivred"},
				{"2", "product", "Rowing", "nabeul", "delivred"},
				{"712", "product", "Knitting", "tunis centre vile", "Not delivred"},
				{"265", "auction", "Speed reading", "ariana", "delivred"},
				{"175", "auction", "Pool", new Integer(10), "Not delivred"},
			},
			new String[] {
				"Id item", "Type", "Id Client", "adress", "state"
			}
		));
//panel.add(new JScrollPane(table));
		
		JButton btnNewButton = new JButton("Take this order");
		btnNewButton.setBackground(UIManager.getColor("CheckBox.light"));
		btnNewButton.setBounds(280, 392, 131, 29);
		contentPane.add(btnNewButton);
	}
}

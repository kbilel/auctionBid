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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import java.awt.Dimension;

public class EspaceManager extends JFrame {

	private JPanel contentPane;
	JScrollPane scrollPane = new JScrollPane();
	PanelHomeManager panelHomeManager=new PanelHomeManager();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EspaceManager frame = new EspaceManager();
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
	public EspaceManager() {
		scrollPane.setViewportView(panelHomeManager);
		setIconImage(Toolkit.getDefaultToolkit().getImage(EspaceManager.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		setTitle("Auction");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.setBackground(SystemColor.activeCaption);
		menuBar.setToolTipText("");
		menuBar.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 16));
		setJMenuBar(menuBar);
		
		JMenuItem mntmHome = new JMenuItem("Home");
		mntmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setViewportView(panelHomeManager);
				
			}
		});
		
		menuBar.add(mntmHome);
		
		JMenuItem mntmAuctions = new JMenuItem("Auctions");
		mntmAuctions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelManageAuction panelManageAuction=new PanelManageAuction();
				scrollPane.setViewportView(panelManageAuction);
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
		contentPane.setLayout(null);
		
		
		scrollPane.setBounds(10, 11, 856, 483);
		contentPane.add(scrollPane);
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(876, 169, 199, 258);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Manager");
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
				Authentification frame = new Authentification();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(68, 211, 121, 36);
		panel.add(button);
	}
}

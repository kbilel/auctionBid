package tn.esprit.auction.gui.authentification;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;

import tn.esprit.auction.delegate.GestionUserDelegate;
import tn.esprit.auction.domain.Admin;
import tn.esprit.auction.domain.Client;
import tn.esprit.auction.domain.DeliveryMan;
import tn.esprit.auction.domain.Manager;
import tn.esprit.auction.domain.StockManager;
import tn.esprit.auction.domain.User;
import tn.esprit.auction.gui.DeliveryMan.EspaceDeliveryMan;
import tn.esprit.auction.gui.admin.EspaceAdmin;
import tn.esprit.auction.gui.client.EspaceClient;
import tn.esprit.auction.gui.client.SubscribingSpace;
import tn.esprit.auction.gui.manager.EspaceManager;
import tn.esprit.auction.gui.stockManager.EspaceStockManager;

import java.awt.Color;

public class Authentification extends JFrame {
 private static User userConnected;
	private JPanel contentPane;
	private JTextField tfLogin;
	private JTextField tfPassword;

	/**
	 * Launch the application.
	 */
	public static User getUser()
	{
		return userConnected;
	}
	public static void setUser(User user)
	{
		 userConnected=user;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification frame = new Authentification();
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
	public Authentification() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(5, 5, 522, 539);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAuthentification = new JLabel("    Authentification");
		lblAuthentification.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblAuthentification.setBounds(10, 11, 502, 55);
		panel.add(lblAuthentification);
		
		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setBounds(77, 159, 118, 55);
		panel.add(lblLogin);
		
		JLabel lblPassword = new JLabel("password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(77, 242, 145, 55);
		panel.add(lblPassword);
		
		tfLogin = new JTextField();
		tfLogin.setBounds(240, 159, 225, 41);
		panel.add(tfLogin);
		tfLogin.setColumns(10);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(240, 242, 225, 41);
		panel.add(tfPassword);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				 String username=tfLogin.getText();
			        String pwd= new String(tfPassword.getText());
			      
			        if(GestionUserDelegate.doAuthentificate(username, pwd)!=null)
				 {
			        	
					 userConnected=GestionUserDelegate.doAuthentificate(username, pwd);
					 if(userConnected instanceof Client)
						{
						 //new EspaceClient().setVisible(true);
						 new EspaceClient().setVisible(true);
						 setVisible(false);
						}
					 else if(userConnected instanceof Manager)
					 {
						 new EspaceManager().setVisible(true);
						 setVisible(false);
					 }
					 
					 else if(userConnected instanceof Admin)
					 {
						 new EspaceAdmin().setVisible(true);
						 setVisible(false);
					 }
					 else if(userConnected instanceof DeliveryMan)
					 {
						 new EspaceDeliveryMan().setVisible(true);
						 setVisible(false);
					 }
					 else if(userConnected instanceof StockManager)
					 {
						 new EspaceStockManager().setVisible(true);
						 setVisible(false);
					 }
					 
				 }
			        else 
			        {
			        	JOptionPane.showMessageDialog(panel, "ouuupss try again ");
			        }
					 

				
			}
		});
		btnConnect.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConnect.setBounds(190, 323, 118, 34);
		panel.add(btnConnect);
		
		JButton btnSubscribe = new JButton("subscribe");
		btnSubscribe.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSubscribe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new SubscribingSpace().setVisible(true);
				 setVisible(false);
				
			}
		});
		btnSubscribe.setBounds(190, 368, 118, 34);
		panel.add(btnSubscribe);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Authentification.class.getResource("/tn/esprit/auction/gui/authentification/bid1.gif")));
		lblNewLabel.setBounds(312, 412, 200, 109);
		panel.add(lblNewLabel);
	}
}

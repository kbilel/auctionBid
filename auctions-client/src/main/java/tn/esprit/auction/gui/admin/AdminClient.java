package tn.esprit.auction.gui.admin;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JLabel;
import javax.swing.JButton;

import tn.esprit.auction.delegate.GestionUserDelegate;
import tn.esprit.auction.domain.Client;
import javax.swing.JTextField;

public class AdminClient extends JPanel {
	private JTable table;
	private JTable tableClients;
	JLabel labelAdresse;
	JLabel labelImage;
	JLabel labelname;
	JLabel labelUsername;
	JLabel labelPassword;
	JLabel labelEmail;
	JLabel labelTokens;
	Client client=null;
	private String username;
	private JTextField usernameSearch;

	/**
	 * Create the panel.
	 */
	public AdminClient() {
		setBounds(0, 0, 1800, 750);
		
		setBackground(new Color(248, 248, 255));
		setLayout(null);
		
		final JPanel panelClient = new JPanel();
		panelClient.setBackground(new Color(250, 250, 210));
		panelClient.setBounds(0, 0, 1800, 750);
		add(panelClient);
		panelClient.setLayout(null);
		tableClients = new JTable();
		usernameSearch = new JTextField();
		usernameSearch.setBounds(728, 11, 199, 49);
		panelClient.add(usernameSearch);
		usernameSearch.setColumns(10);
		tableClients.setModel(new ListClient());
		
		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(AdminClient.class.getResource("/tn/esprit/auction/gui/client/boutonSearch.png")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username=usernameSearch.getText();
				if(!username.equals(""))
					tableClients.setModel(new ListClient(username));	
				else
					tableClients.setModel(new ListClient());
					
				
			}
		});
		btnSearch.setBounds(954, 11, 169, 49);
		panelClient.add(btnSearch);
		
		
		
		tableClients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int row = tableClients.getSelectedRow();
			        
			      // String  name=tableClients.getModel().getValueAt(row,0).toString();
			        String idd=tableClients.getModel().getValueAt(row,0).toString();
			        int id=Integer.parseInt(idd);
			        client= (Client)GestionUserDelegate.doFindUserById(id);
			        
			        labelname.setText(client.getFullName());
					labelUsername.setText(client.getUserName());
					labelPassword.setText(client.getPassword());
					labelEmail.setText(client.getEmail());
					labelAdresse.setText(client.getAdress());
					labelTokens.setText(client.getNumberTockens().toString());
					byte[] imageB = null;
			        try
			        {
					String ch1=client.getImageUrl();
			        String ch="c:/";
			       String ch2=ch.concat(ch1);
			        String ch3=ch2.replace('/','\\');
			        File imageF=new File(ch3);
			        System.out.println(ch3);
			        FileInputStream fis=new FileInputStream(imageF);
			        ByteArrayOutputStream bos=new ByteArrayOutputStream();
			        byte[] buf = new byte[1024]; 
			        for(int readNum;(readNum=fis.read(buf))!=-1;)
			        {
			          bos.write(buf,0,readNum);
			        }
			        imageB=bos.toByteArray();
			       
			        
			    }catch(Exception ee)
			    {
			        JOptionPane.showMessageDialog(null,ee);
			    }
			     
			            Image img = Toolkit.getDefaultToolkit().createImage(imageB);
			        ImageIcon icon =new ImageIcon(img);
			        labelImage.setIcon(icon);   

			      // detail.jLabelname.setText(name);
			}
		});
		tableClients.setFont(new Font("Tahoma", Font.BOLD, 15));
		tableClients.setBackground(new Color(253, 245, 230));
		tableClients.setBounds(544, 122, 586, 406);
		//tableClients.setModel(new ListClient());
		panelClient.add(tableClients);
		
		 labelImage = new JLabel("");
		labelImage.setIcon(new ImageIcon(AdminClient.class.getResource("/tn/esprit/auction/gui/authentification/User-icon.png")));
		labelImage.setBounds(117, 29, 267, 221);
		panelClient.add(labelImage);
		
		JLabel lblName = new JLabel("name");
		lblName.setForeground(new Color(245, 222, 179));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblName.setBounds(182, 276, 79, 31);
		panelClient.add(lblName);
		
		 labelname = new JLabel("---------");
		 labelname.setForeground(new Color(245, 222, 179));
		labelname.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelname.setBounds(307, 281, 141, 23);
		panelClient.add(labelname);
		
		JLabel lblUsername = new JLabel("userName");
		lblUsername.setForeground(new Color(245, 222, 179));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblUsername.setBounds(182, 329, 115, 31);
		panelClient.add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setForeground(new Color(245, 222, 179));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPassword.setBounds(182, 379, 115, 31);
		panelClient.add(lblPassword);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setForeground(new Color(245, 222, 179));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEmail.setBounds(182, 432, 79, 31);
		panelClient.add(lblEmail);
		
		JLabel lblAdresse = new JLabel("adresse");
		lblAdresse.setForeground(new Color(255, 248, 220));
		lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAdresse.setBounds(182, 484, 79, 31);
		panelClient.add(lblAdresse);
		
		 labelUsername = new JLabel("---------");
		 labelUsername.setForeground(new Color(245, 222, 179));
		labelUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelUsername.setBounds(307, 337, 141, 23);
		panelClient.add(labelUsername);
		
		 labelPassword = new JLabel("---------");
		 labelPassword.setForeground(new Color(245, 222, 179));
		labelPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelPassword.setBounds(307, 384, 141, 23);
		panelClient.add(labelPassword);
		
		 labelEmail = new JLabel("---------");
		 labelEmail.setForeground(new Color(245, 222, 179));
		labelEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelEmail.setBounds(307, 437, 141, 23);
		panelClient.add(labelEmail);
		
		 labelAdresse = new JLabel("---------");
		 labelAdresse.setForeground(new Color(245, 222, 179));
		labelAdresse.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelAdresse.setBounds(307, 489, 141, 23);
		panelClient.add(labelAdresse);
		
		JLabel lblNombreToken = new JLabel("tokens");
		lblNombreToken.setForeground(new Color(255, 248, 220));
		lblNombreToken.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNombreToken.setBounds(182, 542, 79, 31);
		panelClient.add(lblNombreToken);
		
		 labelTokens = new JLabel("---------");
		 labelTokens.setForeground(new Color(245, 222, 179));
		labelTokens.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelTokens.setBounds(307, 545, 141, 23);
		panelClient.add(labelTokens);
		
		JButton btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon(AdminClient.class.getResource("/tn/esprit/auction/gui/client/boutonDelete.png")));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(client!=null)
				{if(GestionUserDelegate.doDeleteUser(client))
				{
					client=null;
					labelEmail.setText("------");
					labelAdresse.setText("------");
					labelname.setText("------");
					labelUsername.setText("------");
					labelPassword.setText("------");
					labelTokens.setText("------");
					labelImage.setIcon(new ImageIcon(EspaceAdmin.class.getResource("/tn/esprit/auction/gui/authentification/User-icon.png")));
					
					tableClients.setModel(new ListClient());
				    panelClient.add(tableClients);
				}}
				else 
				{
					JOptionPane.showMessageDialog(panelClient, "ouuupss you have to choose a client to delete ");
				
				
				}
			}
		});
		btnDelete.setBounds(383, 579, 169, 36);
		panelClient.add(btnDelete);
		
		JButton btnSendMail = new JButton("send Mail");
		btnSendMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MailJFrame().setVisible(true);
			}
		});
		btnSendMail.setBounds(284, 579, 89, 23);
		panelClient.add(btnSendMail);
		
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AdminClient.class.getResource("/tn/esprit/auction/gui/client/back.jpg")));
		label.setBounds(0, 0, 1800, 750);
		panelClient.add(label);

	}
}

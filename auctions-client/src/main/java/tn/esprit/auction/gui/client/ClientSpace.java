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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JPasswordField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import tn.esprit.auction.delegate.GestionAuctionDelegate;
import tn.esprit.auction.delegate.GestionConfigurationDelegate;
import tn.esprit.auction.delegate.GestionProductDelegate;
import tn.esprit.auction.delegate.GestionUserDelegate;
import tn.esprit.auction.domain.Auction;
import tn.esprit.auction.domain.Client;
import tn.esprit.auction.domain.Configuration;
import tn.esprit.auction.domain.DutchAuction;
import tn.esprit.auction.domain.EnglishAuction;
import tn.esprit.auction.domain.NegociatedAuction;
import tn.esprit.auction.domain.Product;
import tn.esprit.auction.domain.User;
import tn.esprit.auction.domain.YankeeAuction;


import tn.esprit.auction.gui.authentification.Authentification;
import tn.esprit.auction.gui.authentification.HomeAllUsers;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientSpace extends JFrame {
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
					ClientSpace frame = new ClientSpace();
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
	public ClientSpace() {
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(0, 0, 0));
		tabbedPane.setForeground(new Color(255, 239, 213));
		tabbedPane.setBounds(0, 0, 1122, 790);
		panel.add(tabbedPane);
		
		JPanel panelHome = new JPanel();
		tabbedPane.addTab("home", null, panelHome, null);
		panelHome.setLayout(null);
		
		JPanel panelAuction = new JPanel();
		tabbedPane.addTab("auctions", null, panelAuction, null);
		panelAuction.setLayout(null);
		
		JPanel panelProducts = new JPanel();
		tabbedPane.addTab("products", null, panelProducts, null);
		panelProducts.setLayout(null);
		
		JPanel panelStatistic = new JPanel();
		tabbedPane.addTab("statistic", null, panelStatistic, null);
		panelStatistic.setLayout(null);
		
		JTabbedPane tabbedPaneStatistic = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPaneStatistic.setBounds(0, 5, 1117, 757);
		panelStatistic.add(tabbedPaneStatistic);
		
		JPanel panelStatisticAuctionsCategories = new JPanel();
		tabbedPaneStatistic.addTab("auction 's categories", null, panelStatisticAuctionsCategories, null);
		
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
       dataset.setValue("England",negocietedAuction);
       dataset.setValue("Other", auction5);
       graphe = ChartFactory.createPieChart3D("Pie Chart Country", dataset,true, true, true);
       
       cp = new ChartPanel(graphe);
       panelStatisticAuctionsCategories.add(cp);
       //tabbedPane.addTab("New tab", null, cp, null);
		/********Stat*******/
		JPanel panelStatisticProductCtegories = new JPanel();
		tabbedPaneStatistic.addTab("product's categories", null, panelStatisticProductCtegories, null);
		
		/********Stat*******/
		 List<Product> products=new ArrayList<Product>();
		 products=GestionProductDelegate.doFindAllProducts();
		 List<String> categories=new ArrayList<String>();
		 List<Integer> nbrProd=new ArrayList<Integer>();
		 Map<String, Integer> mapCategorie = new HashMap<String, Integer>();
		 mapCategorie.put(products.get(0).getCategory(),1);

		
		
		 Integer compteur=0;
		 for (Product product : products) {
			 if(compteur>0)
			 { System.out.println("nbr Categories ="+ mapCategorie.get("Home"));
				
				 if(mapCategorie.containsKey(product.getCategory()))
				{
					mapCategorie.put(product.getCategory(),mapCategorie.get(product.getCategory())+1);
					
				}
				else
					mapCategorie.put(product.getCategory(),1);
			 }
			 compteur++;
			
		}
		
		
		 dataset = new DefaultPieDataset();
		 
      
		 Set listKeys=mapCategorie.keySet();  // Obtenir la liste des clés
 		Iterator iterateur=listKeys.iterator();
 		// Parcourir les clés et afficher les entrées de chaque clé;
 		
 		while(iterateur.hasNext())
 		{
 			
 			String key= (String) iterateur.next();
 			 System.out.println("nbr Categories ="+ key);
 			
 			 dataset.setValue(key,(Integer) mapCategorie.get(key));
 		}            
          

      
      
     
     
      
      graphe = ChartFactory.createPieChart3D("Pie Chart Country", dataset,true, true, true);
      
      cp = new ChartPanel(graphe);
      panelStatisticProductCtegories.add(cp);
      //tabbedPane.addTab("New tab", null, cp, null);
		/********Stat Product*******/
		JPanel panel_3 = new JPanel();
		
		JPanel panelAboutUs = new JPanel();
		tabbedPane.addTab("about us", null, panelAboutUs, null);
		
		
		final JPanel panelProfile = new JPanel();
		panelProfile.setBackground(new Color(245, 255, 250));
		tabbedPane.addTab("profil", null, panelProfile, null);
		panelProfile.setLayout(null);
		
		final JLabel labelImageUser = new JLabel("");
		labelImageUser.setIcon(new ImageIcon(EspaceClient.class.getResource("/tn/esprit/auction/gui/authentification/User-icon.png")));
		labelImageUser.setBounds(419, 5, 215, 212);
		panelProfile.add(labelImageUser);
		
		JButton btnAddImgEdit = new JButton("add");
		//btnAddImgEdit.setVisible(false);
		btnAddImgEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser chooser = new JFileChooser();
			        chooser.showOpenDialog(null);
			        File f=chooser.getSelectedFile();
			        pathImg=f.getAbsolutePath();
			        System.out.println("path="+pathImg);
			       try
			        {
			            File image=new File(pathImg);
			            FileInputStream fis=new FileInputStream(image);
			            ByteArrayOutputStream bos=new ByteArrayOutputStream();
			            byte[] buf = new byte[1024]; 
			            for(int readNum;(readNum=fis.read(buf))!=-1;)
			            {
			              bos.write(buf,0,readNum);
			            }
			           imageUserByte=bos.toByteArray();
			           
			            
			        }catch(Exception ex)
			        {
			            JOptionPane.showMessageDialog(null,ex);
			        }
			        
			     labelImageUser.setIcon(new ImageIcon(""+f));
			        
			         Path path=Paths.get(pathImg);
			       String ch=path.getParent().toString();
			       String ch1=path.getFileName().toString();
			        System.out.println("pathBaya="+ch1);
			        String ch0 ="imageAuction/";
			       String ch2=ch0.concat(ch1);
			       String ch3=ch2.replace('\\', '/');
			       imageUserPath=ch3;
			        //ch3=ch.replace('\\', '/');
			       tfPathImageUser.setText(ch3);
			}
		});
		btnAddImgEdit.setBounds(496, 228, 89, 23);
		panelProfile.add(btnAddImgEdit);
		
		JLabel lblFullName = new JLabel("Full name :");
		lblFullName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFullName.setBounds(21, 307, 130, 30);
		panelProfile.add(lblFullName);
		
		JLabel labelFullname = new JLabel("-------------------");
		labelFullname.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelFullname.setBounds(206, 307, 252, 30);
		panelProfile.add(labelFullname);
		
		JLabel lblLogin = new JLabel("login :");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLogin.setBounds(21, 365, 130, 30);
		panelProfile.add(lblLogin);
		
		JLabel lblPassword = new JLabel("password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(21, 427, 130, 30);
		panelProfile.add(lblPassword);
		
		JLabel lblEmail = new JLabel("email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(21, 488, 130, 30);
		panelProfile.add(lblEmail);
		
		JLabel lblAdresse = new JLabel("adresse :");
		lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdresse.setBounds(21, 554, 130, 30);
		panelProfile.add(lblAdresse);
		
		JLabel lblTokenNumber = new JLabel("token number :");
		lblTokenNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTokenNumber.setBounds(21, 615, 130, 30);
		panelProfile.add(lblTokenNumber);
		
		JLabel labelLogin = new JLabel("----------------");
		labelLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelLogin.setBounds(206, 365, 252, 30);
		panelProfile.add(labelLogin);
		
		JLabel labelPassword = new JLabel("----------------");
		labelPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelPassword.setBounds(206, 427, 252, 30);
		panelProfile.add(labelPassword);
		
		JLabel labelEmail = new JLabel("----------------");
		labelEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelEmail.setBounds(206, 488, 252, 30);
		panelProfile.add(labelEmail);
		
		JLabel labelAdresse = new JLabel("----------------");
		labelAdresse.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelAdresse.setBounds(206, 554, 252, 30);
		panelProfile.add(labelAdresse);
		
		JLabel labelToken = new JLabel("----------------");
		labelToken.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelToken.setBounds(206, 615, 252, 30);
		panelProfile.add(labelToken);
		
		passwordFieldEdit = new JPasswordField();
		passwordFieldEdit.setBounds(466, 427, 302, 30);
		passwordFieldEdit.setVisible(false);
		panelProfile.add(passwordFieldEdit);
		
		tfFullnameEdit = new JTextField();
		tfFullnameEdit.setBounds(468, 307, 302, 30);
		tfFullnameEdit.setVisible(false);
		panelProfile.add(tfFullnameEdit);
		tfFullnameEdit.setColumns(10);
		
		tfLoginEdit = new JTextField();
		tfLoginEdit.setColumns(10);
		tfLoginEdit.setBounds(466, 365, 302, 30);
		tfLoginEdit.setVisible(false);
		panelProfile.add(tfLoginEdit);
		
		tfEmailEdit = new JTextField();
		tfEmailEdit.setColumns(10);
		tfEmailEdit.setBounds(468, 488, 302, 30);
		tfEmailEdit.setVisible(false);
		panelProfile.add(tfEmailEdit);
		
		tfAdresseEdit = new JTextField();
		tfAdresseEdit.setColumns(10);
		tfAdresseEdit.setBounds(468, 554, 302, 30);
		tfAdresseEdit.setVisible(false);
		panelProfile.add(tfAdresseEdit);
		
		final JButton btnDeleteUser = new JButton("delete");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GestionUserDelegate.doDeleteUser(userConnected))
				{
					userConnected=null;
					SubscribingSpace.setUser(userConnected);
					Authentification.setUser(userConnected);
					new HomeAllUsers().setVisible(true);
					setVisible(false);
				}
			}
		});
		btnDeleteUser.setBounds(398, 710, 89, 23);
		panelProfile.add(btnDeleteUser);
		
		JButton btnEditUser = new JButton("edit");
		btnEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(userConnected!=null)
				{
					
					tfFullnameEdit.setText(userConnected.getFullName());
					
					tfLoginEdit.setText(userConnected.getUserName());
					passwordFieldEdit.setText(userConnected.getPassword());
					tfEmailEdit.setText(userConnected.getEmail());
					tfAdresseEdit.setText(userConnected.getAdress());
					tfPathImageUser.setText(userConnected.getImageUrl());
					tfFullnameEdit.setVisible(true);
					tfLoginEdit.setVisible(true);
					passwordFieldEdit.setVisible(true);
					tfEmailEdit.setVisible(true);
					tfAdresseEdit.setVisible(true);
					tfPathImageUser.setVisible(true);
					btnDeleteUser.setVisible(true);
					
					
				}
			}
		});
		btnEditUser.setBounds(566, 710, 89, 23);
		panelProfile.add(btnEditUser);
		
		JButton btnValidateEdit = new JButton("validate Edit");
		btnValidateEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String username=tfLoginEdit.getText();
			        String email=tfEmailEdit.getText();
			        String pwd=new String(passwordFieldEdit.getText());
			        
			        int msg=0;
			        int compteur=0;
			       int index1=email.indexOf("@");
			       int index2=email.indexOf(".");
			        
			        
			        if(tfFullnameEdit.getText().equals("")||username.equals("")||email.equals("")||pwd.equals("")||tfPathImageUser.equals(""))
			        {   System.out.println(msg);
			        	msg++; 
			       JOptionPane.showMessageDialog(panelProfile, "ouuupss try Again champs Vide");
			        
			        }
			        if(index1==0 || index1==email.length() || index2==0 || index2==email.length() || index1==-1 || index2==-1 || index2==(index1+1))
			        {
			            msg++;
			            System.out.println(msg);
			            JOptionPane.showMessageDialog(panelProfile, "ouuupss try again email invalide");
			        }
			        if(!username.equals(userConnected.getUserName()) || !pwd.equals(userConnected.getPassword()) )
			        { if(GestionUserDelegate.doAuthentificate(username, pwd)!=null)
			        {
			            System.out.println(msg);

			        	msg++;
			            JOptionPane.showMessageDialog(panelProfile, "ouuupss try again username exisist");
			        }}
			        if(msg==0)	
				{Client client1=(Client) userConnected;

					 client1.setFullName(tfFullnameEdit.getText());
					client1.setEmail(tfEmailEdit.getText());
					client1.setAdress(tfAdresseEdit.getText());
					client1.setUserName(tfLoginEdit.getText());
					client1.setPassword(new String(passwordFieldEdit.getText()));
					client1.setImageUrl(tfPathImageUser.getText());
					//client1.setImageByte(imageUserByte);
					
					
				
					if(GestionUserDelegate.doUpdateUser(client1))
					 {
						 userConnected=client1;
						 new EspaceClient().setVisible(true);
						 setVisible(false);
						 System.out.println("ouiiiiiiiiiiii inscri mrigla");
					 }
				}
			        else msg=0;
			}
		});
		btnValidateEdit.setBounds(680, 710, 108, 23);
		panelProfile.add(btnValidateEdit);
		
		tfPathImageUser = new JTextField();
		tfPathImageUser.setBounds(698, 229, 257, 20);
		tfPathImageUser.setVisible(false);
		panelProfile.add(tfPathImageUser);
		tfPathImageUser.setColumns(10);
		
		if(userConnected!=null)
		{
			if(userConnected instanceof Client)
			{
				client=(Client)userConnected ;
				labelToken.setText(""+client.getNumberTockens());
			}
			
			labelFullname.setText(userConnected.getFullName());
			labelLogin.setText(userConnected.getUserName());
			labelPassword.setText(userConnected.getPassword());
			labelEmail.setText(userConnected.getEmail());
			labelAdresse.setText(userConnected.getAdress());
			
            byte[] imageB = null;
            try
            {
			String ch1=userConnected.getImageUrl();
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
           
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
         
                Image img = Toolkit.getDefaultToolkit().createImage(imageB);
            ImageIcon icon =new ImageIcon(img);
            labelImageUser.setIcon(icon);
				
		}
		
	}
}

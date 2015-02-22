package tn.esprit.auction.gui.client;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JLabel;

import tn.esprit.auction.delegate.GestionUserDelegate;
import tn.esprit.auction.domain.Client;
import tn.esprit.auction.domain.User;
import tn.esprit.auction.gui.authentification.Authentification;
import tn.esprit.auction.gui.authentification.HomeAllUsers;

public class PanelProfil extends JPanel {
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

	
		/**
	 * Create the panel.
	 */
	public PanelProfil() {
		setBounds(0, 0, 1158, 850);
		client=new Client();
		userConnected= HomeClient.userConnected;
		if(HomeClient.userConnected==null)
		{
			System.out.println("euuu chbiih fil profil null za3ma !!! ");
		}
		else
			System.out.println("ouuh 3ala ayèmi ty haw mawjouud l user fil profil za7 !!! ");
			
		      if(userConnected==null)
		    	  userConnected = SubscribingPanel.userConnected;
		     System.out.println("ouuuuuuuuuuuuh ouh ="+new HomeClient().userConnected.getUserName()); 
		setLayout(null);
		
		final JPanel panelProfile = new JPanel();
		panelProfile.setBackground(new Color(253, 245, 230));
		panelProfile.setForeground(Color.BLACK);
		panelProfile.setBounds(0, 0, 1142, 791);
		add(panelProfile);
		panelProfile.setLayout(null);
		final JLabel labelImageUser = new JLabel("");
		labelImageUser.setIcon(new ImageIcon(EspaceClient.class.getResource("/tn/esprit/auction/gui/authentification/User-icon.png")));
		labelImageUser.setBounds(419, 5, 215, 212);
		panelProfile.add(labelImageUser);
		
		JButton btnAddImgEdit = new JButton("add");
		//btnAddImgEdit.setVisible(false);
		btnAddImgEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(userConnected!=null)
				{
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
				else 
				{
					JOptionPane.showMessageDialog(panelProfile, "you have to connect before");
				}
			}
		});
		btnAddImgEdit.setBounds(496, 228, 89, 23);
		panelProfile.add(btnAddImgEdit);
		
		JLabel lblFullName = new JLabel("Full name :");
		lblFullName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFullName.setBounds(21, 307, 130, 30);
		panelProfile.add(lblFullName);
		
		final JLabel labelFullname = new JLabel("-------------------");
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
		
		final JLabel labelLogin = new JLabel("----------------");
		labelLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelLogin.setBounds(206, 365, 252, 30);
		panelProfile.add(labelLogin);
		
		final JLabel labelPassword = new JLabel("----------------");
		labelPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelPassword.setBounds(206, 427, 252, 30);
		panelProfile.add(labelPassword);
		
		final JLabel labelEmail = new JLabel("----------------");
		labelEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelEmail.setBounds(206, 488, 252, 30);
		panelProfile.add(labelEmail);
		
		final JLabel labelAdresse = new JLabel("----------------");
		labelAdresse.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelAdresse.setBounds(206, 554, 252, 30);
		panelProfile.add(labelAdresse);
		
		final JLabel labelToken = new JLabel("----------------");
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
				if(userConnected!=null)
				{
				if(GestionUserDelegate.doDeleteUser(userConnected))
				{
					userConnected=null;
					SubscribingSpace.setUser(userConnected);
					Authentification.setUser(userConnected);
					labelImageUser.setIcon(new ImageIcon(EspaceClient.class.getResource("/tn/esprit/auction/gui/authentification/User-icon.png")));
					labelFullname.setText("---------");
					labelLogin.setText("---------------");
					labelPassword.setText("-------------");
					labelEmail.setText("-----------");
					labelAdresse.setText("-----------------");
					labelToken.setText("----------");
					
					
					
				}}
				else 
				{
					JOptionPane.showMessageDialog(panelProfile, "you have to connect before");
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
					System.out.println("userConnected fil afichage ta3 profil id="+userConnected.getId());
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
				else 
				{
					JOptionPane.showMessageDialog(panelProfile, "you have to connect before");
				}
			}
		});
		btnEditUser.setBounds(566, 710, 89, 23);
		panelProfile.add(btnEditUser);
		
		JButton btnValidateEdit = new JButton("validate Edit");
		btnValidateEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(userConnected!=null)
				{
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
                    client1.setId(userConnected.getId());
                    System.out.println("ouuuh il user id="+client1.getId());
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
						 tfFullnameEdit.setText(userConnected.getFullName());
							
							tfLoginEdit.setText(userConnected.getUserName());
							passwordFieldEdit.setText(userConnected.getPassword());
							tfEmailEdit.setText(userConnected.getEmail());
							tfAdresseEdit.setText(userConnected.getAdress());
							tfPathImageUser.setText(userConnected.getImageUrl());
							tfFullnameEdit.setVisible(false);
							tfLoginEdit.setVisible(false);
							passwordFieldEdit.setVisible(false);
							tfEmailEdit.setVisible(false);
							tfAdresseEdit.setVisible(false);
							tfPathImageUser.setVisible(false);
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
				           
				            
				        }catch(Exception ee)
				        {
				            JOptionPane.showMessageDialog(null,e);
				        }
				         
				                Image img = Toolkit.getDefaultToolkit().createImage(imageB);
				            ImageIcon icon =new ImageIcon(img);
				            labelImageUser.setIcon(icon);
						 
						 
						 System.out.println("ouiiiiiiiiiiii inscri mrigla");
					 }
				}
			        else msg=0;
				}
				else 
				{
					JOptionPane.showMessageDialog(panelProfile, "you have to connect before");
				}
			}
		});
		btnValidateEdit.setBounds(680, 710, 108, 23);
		panelProfile.add(btnValidateEdit);
		
		tfPathImageUser = new JTextField();
		tfPathImageUser.setBounds(698, 229, 257, 20);
		tfPathImageUser.setVisible(false);
		panelProfile.add(tfPathImageUser);
		tfPathImageUser.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PanelProfil.class.getResource("/tn/esprit/auction/gui/authentification/back1.jpg")));
		label.setBounds(0, 0, 1158, 850);
		panelProfile.add(label);
		
		if(userConnected!=null)
		{ System.out.println("femma user chbbii weldiih ma y7ottouch");
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
		else 
		{
			System.out.println("ouuuuuh chbiiih userConnected null -_-");
		}
		

	}
}

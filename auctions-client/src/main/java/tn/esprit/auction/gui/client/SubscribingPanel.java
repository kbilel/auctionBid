package tn.esprit.auction.gui.client;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.MatteBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

import tn.esprit.auction.delegate.GestionConfigurationDelegate;
import tn.esprit.auction.delegate.GestionUserDelegate;
import tn.esprit.auction.domain.Client;
import tn.esprit.auction.domain.Configuration;
import tn.esprit.auction.domain.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SubscribingPanel extends JPanel {
	private User client;
 static User userConnected;
	private String pathImg;
	private String imageUserPath;
   byte[] imageUserByte=null;
	private JTextField tfUsername;
	private JTextField tfLogin;
	private JTextField tfAdresse;
	private JPasswordField passwordField;
	private JTextField tfEmail;
	private JTextField tfPathImage;

	/**
	 * Create the panel.
	 */
	public SubscribingPanel() {
		setLayout(null);
		final User user=HomeClient.userConnected;
		setBounds(0, 0, 1800, 750);
		
		final JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 224));
		panel.setBounds(0, 0, 1800, 750);
		add(panel);
		
		JLabel label = new JLabel("Register For Free Now !!");
		label.setForeground(new Color(245, 222, 179));
		label.setFont(new Font("Tahoma", Font.BOLD, 35));
		label.setBackground(new Color(210, 105, 30));
		label.setBounds(426, 0, 484, 89);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(44, 52, 46, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("username :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(23, 456, 160, 41);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("login :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(23, 512, 160, 41);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("password :");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_4.setBounds(23, 557, 160, 41);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("email:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_5.setBounds(23, 606, 160, 41);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("adresse :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_6.setBounds(23, 660, 160, 41);
		panel.add(label_6);
		
		final JLabel label_7 = new JLabel("");
		label_7.setBackground(Color.WHITE);
		label_7.setIcon(new ImageIcon(SubscribingPanel.class.getResource("/tn/esprit/auction/gui/client/profilClient.png")));
		label_7.setBounds(518, 73, 218, 225);
		panel.add(label_7);
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(238, 460, 368, 41);
		panel.add(tfUsername);
		
		tfLogin = new JTextField();
		tfLogin.setColumns(10);
		tfLogin.setBounds(238, 512, 368, 41);
		panel.add(tfLogin);
		
		tfAdresse = new JTextField();
		tfAdresse.setColumns(10);
		tfAdresse.setBounds(238, 664, 368, 41);
		panel.add(tfAdresse);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(238, 564, 368, 35);
		panel.add(passwordField);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(238, 610, 368, 41);
		panel.add(tfEmail);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(SubscribingPanel.class.getResource("/tn/esprit/auction/gui/client/boutonRegister.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(user!=null)
				{
					 JOptionPane.showMessageDialog(panel, "ouuupss you have to deconnect");
				}
				else
				{
				String username=tfLogin.getText();
		        String email=tfEmail.getText();
		        String pwd=new String(passwordField.getText());
		        
		        int msg=0;
		        int compteur=0;
		       int index1=email.indexOf("@");
		       int index2=email.indexOf(".");
		        
		        
		        if(tfUsername.getText().equals("")||username.equals("")||email.equals("")||pwd.equals("")||tfPathImage.equals(""))
		        {   System.out.println(msg);
		        	msg++; 
		       JOptionPane.showMessageDialog(panel, "ouuupss try Again champs Vide");
		        
		        }
		        if(index1==0 || index1==email.length() || index2==0 || index2==email.length() || index1==-1 || index2==-1 || index2==(index1+1))
		        {
		            msg++;
		            System.out.println(msg);
		            JOptionPane.showMessageDialog(panel, "ouuupss try again email invalide");
		        }
		        if(GestionUserDelegate.doAuthentificate(username, pwd)!=null)
		        {
		            System.out.println(msg);

		        	msg++;
		            JOptionPane.showMessageDialog(panel, "ouuupss try again username exisist");
		        }
		        if(msg==0)	
			{Client client1=new Client();
			//user user=n
				 client1 = new Client();
				 client1.setFullName(tfUsername.getText());
				client1.setEmail(tfEmail.getText());
				client1.setAdress(tfAdresse.getText());
				client1.setUserName(tfLogin.getText());
				client1.setPassword(new String(passwordField.getText()));
				client1.setImageUrl(tfPathImage.getText());
				//client1.setImageByte(imageUserByte);
				
				List<Configuration> configurations = GestionConfigurationDelegate.doFindAllConfigurations();
			     Configuration configuration=	configurations.get(0) ;
			client1.setNumberTockens(configuration.getNbrTokenParInscription());
				if(GestionUserDelegate.doAddUser(client1))
				 {
					List<User> clients=GestionUserDelegate.doFindAllUsers();
					Client client2=(Client)clients.get((clients.size()-1));
					 userConnected=client2;
					new HomeClient().userConnected=userConnected;
					 System.out.println(" inscri mrigla");
					 new HomeClient().setVisible(true);
					 setVisible(false);
					 System.out.println(" inscri mrigla");
				 }
			}
		        else msg=0;
				}
				
			}
		});
		button_1.setBounds(634, 584, 155, 35);
		panel.add(button_1);
		
		tfPathImage = new JTextField();
		tfPathImage.setColumns(10);
		tfPathImage.setBounds(638, 328, 247, 20);
		panel.add(tfPathImage);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
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
					        
					       label_7.setIcon(new ImageIcon(""+f));
					        
					         Path path=Paths.get(pathImg);
					       String ch=path.getParent().toString();
					       String ch1=path.getFileName().toString();
					        System.out.println("pathBaya="+ch1);
					        String ch0 ="imageAuction/";
					       String ch2=ch0.concat(ch1);
					       String ch3=ch2.replace('\\', '/');
					       imageUserPath=ch3;
					        //ch3=ch.replace('\\', '/');
					       tfPathImage.setText(ch3);
					
			}
		});
		button.setIcon(new ImageIcon(SubscribingPanel.class.getResource("/tn/esprit/auction/gui/authentification/add.png")));
		button.setBounds(541, 309, 46, 44);
		panel.add(button);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(SubscribingPanel.class.getResource("/tn/esprit/auction/gui/client/back.jpg")));
		label_8.setBounds(0, 0, 1800, 750);
		panel.add(label_8);
		
		

	}

}

package tn.esprit.auction.gui.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.border.MatteBorder;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import org.jfree.ui.RefineryUtilities;

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

public class SubscribingSpace extends JFrame {
	private User client;
	private static User userConnected;
	private String pathImg;
	private String imageUserPath;
   byte[] imageUserByte=null;
	private JPanel contentPane;
	private JTextField tfUsername;
	private JTextField tfLogin;
	private JTextField tfAdresse;
	private JPasswordField passwordField;
	private JTextField tfEmail;
	private JTextField tfPathImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubscribingSpace frame = new SubscribingSpace();
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
	public static User getUser()
	{
		return userConnected;
	}
	public static void setUser(User user)
	{
		 userConnected=user;
	}
	
	public SubscribingSpace() {
		//user=new Client();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 21, 1142, 839);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 92, 92));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 224));
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBounds(0, 21, 1142, 791);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register For Free Now !!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBackground(new Color(210, 105, 30));
		lblNewLabel.setBounds(171, 7, 484, 89);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(44, 52, 46, 14);
		panel.add(label);
		
		JLabel lblFirsName = new JLabel("username :");
		lblFirsName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFirsName.setBounds(23, 456, 160, 41);
		panel.add(lblFirsName);
		
		JLabel lblLastName = new JLabel("login :");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLastName.setBounds(23, 512, 160, 41);
		panel.add(lblLastName);
		
		JLabel lblLogin = new JLabel("password :");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setBounds(23, 557, 160, 41);
		panel.add(lblLogin);
		
		JLabel lblPassword = new JLabel("email:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(23, 606, 160, 41);
		panel.add(lblPassword);
		
		JLabel lblEmail = new JLabel("adresse :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmail.setBounds(23, 660, 160, 41);
		panel.add(lblEmail);
		
		 final JLabel labelImage = new JLabel("");
		labelImage.setIcon(new ImageIcon(SubscribingSpace.class.getResource("/tn/esprit/auction/gui/authentification/User-icon.png")));
		labelImage.setBounds(274, 94, 218, 200);
		panel.add(labelImage);
		
		JButton btnAddImage = new JButton("");
		btnAddImage.addActionListener(new ActionListener() {
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
			        
			     labelImage.setIcon(new ImageIcon(""+f));
			        
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
		btnAddImage.setIcon(new ImageIcon(SubscribingSpace.class.getResource("/tn/esprit/auction/gui/authentification/add.png")));
		btnAddImage.setBounds(376, 305, 46, 44);
		panel.add(btnAddImage);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(238, 460, 368, 41);
		panel.add(tfUsername);
		tfUsername.setColumns(10);
		
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
		
		JButton btnRegister = new JButton("register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
					 userConnected=client1;
					 new EspaceClient().setVisible(true);
					 setVisible(false);
					 System.out.println("ouiiiiiiiiiiii inscri mrigla");
				 }
			}
		        else msg=0;
				
				
			}
		});
		btnRegister.setBounds(360, 728, 89, 23);
		panel.add(btnRegister);
		
		tfPathImage = new JTextField();
		tfPathImage.setBounds(453, 318, 247, 20);
		panel.add(tfPathImage);
		tfPathImage.setColumns(10);
	}
}

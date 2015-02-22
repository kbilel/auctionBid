package tn.esprit.auction.gui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Font;

public class MailJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tFsubject;
	private JTextField tFreciever;
	private JTextField tFsender;
	URL url;
    Mail mail = new Mail();
    private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MailJFrame frame = new MailJFrame();
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
	public MailJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 285);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSender = new JLabel("sender");
		lblSender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSender.setBounds(10, 11, 78, 22);
		panel.add(lblSender);
		
		JLabel label = new JLabel("reciever");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(10, 44, 78, 22);
		panel.add(label);
		
		JLabel label_1 = new JLabel("subject");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(10, 106, 78, 22);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("body");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(10, 139, 78, 22);
		panel.add(label_2);
		
		final JTextArea tAbody = new JTextArea();
		tAbody.setBounds(96, 138, 252, 104);
		panel.add(tAbody);
		
		tFsubject = new JTextField();
		tFsubject.setBounds(96, 107, 250, 20);
		panel.add(tFsubject);
		tFsubject.setColumns(10);
		
		tFreciever = new JTextField();
		tFreciever.setColumns(10);
		tFreciever.setBounds(98, 45, 250, 20);
		panel.add(tFreciever);
		
		tFsender = new JTextField();
		tFsender.setColumns(10);
		tFsender.setBounds(96, 12, 250, 20);
		panel.add(tFsender);
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(10, 77, 78, 14);
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(96, 76, 252, 20);
		panel.add(passwordField);
		
		JButton btnSend = new JButton("send");
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        mail.setMailAddressRecipient(tFreciever.getText());
		        mail.setPwd(passwordField.getText());
		        mail.setMailAddressSender(tFsender.getText());
		        mail.setMailSubject(tFsubject.getText());
		        String[] lines = tAbody.getText().split("\\n");
		        String msg="";
		        for(String s:lines){
		            msg = msg+s;
		        }
		        mail.setMailObject(msg);
		        //System.out.println(jTextArearObject.getToolTipText());
		        
		        MailConstruction mc = new MailConstruction();
		        mc.getMailProperties();
		        
		        //String s = this.cleanUrl(url);
		        mc.getMailMessage(mail);
		        mc.SendMessage(); 
		        setVisible(false);
			}

			private String cleanUrl(URL url) {
				 String s = url.toString();
			        System.out.println("Before Clean");
			        System.out.println(s);
			        String delims = "/";
			        String[] tokens = s.split(delims);
			        System.out.println("After Clean");
			        String mailPart="";
			        for (int i=1;i<tokens.length;i++){
			            mailPart+=tokens[i]+"\\\\";
			        }
			        System.out.println(mailPart);
			        return mailPart;
			}
		});
		btnSend.setBounds(162, 253, 89, 23);
		panel.add(btnSend);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MailJFrame.class.getResource("/tn/esprit/auction/gui/admin/backMail1.jpg")));
		lblNewLabel.setBounds(-12, -11, 437, 308);
		panel.add(lblNewLabel);
		
		
	}
	
}

package tn.esprit.auction.gui.manager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

import tn.esprit.auction.delegate.GestionUserDelegate;
import tn.esprit.auction.domain.Client;
import tn.esprit.auction.domain.User;
import tn.esprit.auction.gui.admin.Mail;
import tn.esprit.auction.gui.admin.MailConstruction;
import tn.esprit.auction.gui.authentification.Authentification;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class ConfirmSendMail extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfirmSendMail dialog = new ConfirmSendMail();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfirmSendMail() {
		setTitle("Mailing List");
		setBounds(100, 100, 481, 308);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblAnEmailWill = new JLabel("An email will be send to notify interested clients in \r\nthis category of auctions .\r\n");
		lblAnEmailWill.setBounds(10, 38, 445, 58);
		contentPanel.add(lblAnEmailWill);
		
		JLabel lblPleaseInsertYour = new JLabel("Please insert your Email password .");
		lblPleaseInsertYour.setBounds(37, 119, 254, 14);
		contentPanel.add(lblPleaseInsertYour);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(37, 185, 192, 32);
		contentPanel.add(passwordField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Mail mail = new Mail();
						Authentification authentification=new Authentification();
						Client client =new Client();
						List<User>users=GestionUserDelegate.doFindAllUsers();
						for (User user : users) {
							if (user instanceof Client)
								
							{	client=(Client) user;
							if( client.getCategoryInterestedByClients().contains(ConvertProductToAuction.productSelected)){}
						
							
							mail.setMailAddressRecipient(client.getEmail());
					        mail.setPwd(passwordField.getText());
					        mail.setMailAddressSender(authentification.getUser().getEmail());
					        mail.setMailSubject("Notfication :New Auction added in category : "+ConvertProductToAuction.productSelected.getCategory());
					        
					        String msg="A new auction, belongs to a category you are interested in:"+ConvertProductToAuction.productSelected.getCategory()+" ,has been added , please connect and check it out !";
					        
					        mail.setMailObject(msg);
					        //System.out.println(jTextArearObject.getToolTipText());
					        
					        MailConstruction mc = new MailConstruction();
					        mc.getMailProperties();
					        
					        //String s = this.cleanUrl(url);
					        mc.getMailMessage(mail);
					        mc.SendMessage(); 
						}}
						  
					        setVisible(false);
					}
				});
				
				JButton btnSkip = new JButton("Skip");
				btnSkip.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				buttonPane.add(btnSkip);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}

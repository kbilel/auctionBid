package tn.esprit.auction.gui.client;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
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
import tn.esprit.auction.gui.manager.EspaceManager;
import tn.esprit.auction.gui.stockManager.EspaceStockManager;

public class UserActionListener implements ActionListener {
	private JPanel callerPanel;
	private JTextField loginTF;
	private JPasswordField passwordField;
	public static User userConnected;
	public static User getUserConnected() {
		return userConnected;
	}

	public static void setUserConnected(User userConnected) {
		UserActionListener.userConnected = userConnected;
	}

	String password = "";
	String login = "";
	static Boolean etatVisible;
	private JPanel connectRubriq = new JPanel();
	private JPanel panel = new JPanel();
	private JPanel authentification = new JPanel();
	private JLabel fullname = new JLabel("            ---------");
	private JLabel imgUser = new JLabel("");

	public UserActionListener(JPanel callerPanel, final JTextField loginTF2,
			JPasswordField passwordField2, User userConnected2,
			String password2, String login2, Boolean etatVisible2,
			JPanel connectRubriq2, JPanel panel2, JPanel authentification2,
			JLabel fullname2, JLabel imgUser2) {
		this.callerPanel =callerPanel;
		this.loginTF = loginTF2;
		this.passwordField = passwordField2;
		this.userConnected = userConnected2;
		this.password = password2;
		this.login = login2;
		this.etatVisible = etatVisible2;
		this.connectRubriq = connectRubriq2;
		this.panel = panel2;
		this.authentification = authentification2;
		this.fullname = fullname2;
		this.imgUser = imgUser2;
	}

	public void actionPerformed(ActionEvent e) {
		String username = loginTF.getText();
		String pwd = new String(passwordField.getPassword());

		if (GestionUserDelegate.doAuthentificate(username, pwd) != null) {
			etatVisible = false;

			userConnected = GestionUserDelegate.doAuthentificate(username, pwd);
			if (userConnected instanceof Client) {
				new HomeClient().setVisible(true);
				connectRubriq.setBorder(new LineBorder(new Color(0, 0, 0), 3));
				connectRubriq.setBackground(new Color(100, 149, 237));
				connectRubriq.setBounds(871, 213, 261, 313);
				fullname.setText(userConnected.getFullName());
				byte[] imageB = null;
				try {
					String ch1 = userConnected.getImageUrl();
					String ch = "c:/";
					String ch2 = ch.concat(ch1);
					String ch3 = ch2.replace('/', '\\');
					File imageF = new File(ch3);
					System.out.println(ch3);
					FileInputStream fis = new FileInputStream(imageF);
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					byte[] buf = new byte[1024];
					for (int readNum; (readNum = fis.read(buf)) != -1;) {
						bos.write(buf, 0, readNum);
					}
					imageB = bos.toByteArray();

				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, e);
				}

				Image img = Toolkit.getDefaultToolkit().createImage(imageB);
				ImageIcon icon = new ImageIcon(img);
				imgUser.setIcon(icon);
				panel.add(connectRubriq);
				authentification.setVisible(false);
				connectRubriq.setVisible(true);

			} else if (userConnected instanceof Manager) {
				new EspaceManager().setVisible(true);
				callerPanel.setVisible(false);

			}

			else if (userConnected instanceof Admin) {
				new EspaceAdmin().setVisible(true);
				callerPanel.setVisible(false);
			} else if (userConnected instanceof DeliveryMan) {
				new EspaceDeliveryMan().setVisible(true);
				callerPanel.setVisible(false);
			} else if (userConnected instanceof StockManager) {
				new EspaceStockManager().setVisible(true);
				callerPanel.setVisible(false);
			}

		} else {
			JOptionPane.showMessageDialog(panel, "ouuupss try again ");
			etatVisible = true;
		}

	}

}

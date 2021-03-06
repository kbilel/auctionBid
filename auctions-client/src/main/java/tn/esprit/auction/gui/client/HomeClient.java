package tn.esprit.auction.gui.client;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JPasswordField;

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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class HomeClient extends JPanel {
	private JTextField loginTF;
	private JPasswordField passwordField;
	public static User userConnected;
	String password = "";
	String login = "";
	static Boolean etatVisible;

	/**
	 * Create the panel.
	 */
	public HomeClient() {
		etatVisible = true;
		// userConnected = HomeClient.userConnected;
		if (userConnected == null)
			userConnected = SubscribingPanel.userConnected;
		setBounds(0, 0, 1800, 750);
		setLayout(null);

		final JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1800, 750);
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(93, 0, 1431, 189);
		label.setIcon(new ImageIcon(HomeClient.class
				.getResource("/tn/esprit/auction/gui/client/logo10.png")));
		panel.add(label);

		final JPanel authentification = new JPanel();
		authentification.setBounds(871, 188, 261, 313);
		authentification.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		authentification.setBackground(new Color(100, 149, 237));
		panel.add(authentification);
		authentification.setLayout(null);
		// panel_1.setLayout(null);

		JLabel imageClient = new JLabel("");
		imageClient
				.setIcon(new ImageIcon(
						HomeClient.class
								.getResource("/tn/esprit/auction/gui/authentification/User-icon.png")));
		imageClient.setBounds(74, 11, 156, 148);
		authentification.add(imageClient);

		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(10, 206, 92, 19);
		authentification.add(lblPassword);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLogin.setBounds(10, 175, 55, 19);
		authentification.add(lblLogin);

		loginTF = new JTextField();
		loginTF.setBounds(112, 176, 139, 20);
		authentification.add(loginTF);
		loginTF.setColumns(10);
		JButton btnConnect = new JButton("");
		btnConnect.setIcon(new ImageIcon(HomeClient.class
				.getResource("/tn/esprit/auction/gui/client/boutonLogin.png")));
		btnConnect.setBounds(33, 253, 185, 36);
		authentification.add(btnConnect);

		passwordField = new JPasswordField();
		passwordField.setBounds(112, 207, 139, 20);
		authentification.add(passwordField);

		login = loginTF.getText();
		password = passwordField.getText();

		final JPanel connectRubriq = new JPanel();
		connectRubriq.setBounds(871, 512, 261, 268);
		connectRubriq.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.add(connectRubriq);
		connectRubriq.setLayout(null);

		final JLabel imgUser = new JLabel("");
		imgUser.setIcon(new ImageIcon(
				HomeClient.class
						.getResource("/tn/esprit/auction/gui/authentification/User-icon.png")));
		imgUser.setBounds(23, 11, 214, 173);
		connectRubriq.add(imgUser);

		final JLabel fullname = new JLabel("            ---------");
		fullname.setBounds(87, 195, 164, 25);
		connectRubriq.add(fullname);

		JButton btnDisconnect = new JButton("");
		btnDisconnect
				.setIcon(new ImageIcon(
						HomeClient.class
								.getResource("/tn/esprit/auction/gui/admin/boutonLogoutt.png")));
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userConnected = null;
				SubscribingPanel.userConnected = null;
				new HomeClient().setVisible(true);
				authentification
						.setBorder(new LineBorder(new Color(0, 0, 0), 3));
				authentification.setBackground(new Color(100, 149, 237));
				authentification.setBounds(871, 213, 261, 313);
				panel.add(authentification);
				authentification.setVisible(true);
				connectRubriq.setVisible(false);
			}
		});
		btnDisconnect.setBounds(56, 216, 159, 41);
		connectRubriq.add(btnDisconnect);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(
				HomeClient.class
						.getResource("/tn/esprit/auction/gui/authentification/back1.jpg")));
		label_1.setBounds(0, 0, 1158, 850);
		// panel.add(label_1);
		
		ActionListener userListener = new UserActionListener(this, loginTF, passwordField, userConnected, password, login,etatVisible,
				connectRubriq, panel, authentification, fullname, imgUser);
		btnConnect.addActionListener(userListener);
        userConnected = UserActionListener.userConnected;
		if (userConnected != null) {
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

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}

			Image img = Toolkit.getDefaultToolkit().createImage(imageB);
			ImageIcon icon = new ImageIcon(img);
			imgUser.setIcon(icon);
			panel.add(connectRubriq);
			authentification.setVisible(false);
			connectRubriq.setVisible(true);

		} else {
			authentification.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			authentification.setBackground(new Color(100, 149, 237));
			authentification.setBounds(871, 213, 261, 313);
			panel.add(authentification);
			authentification.setVisible(true);
			connectRubriq.setVisible(false);

		}
		if (userConnected == null) {
			System.out.println("ouuuuh ouh ouh ti chbiih ");
		} else
			System.out.println("ty haw mriguill za7 ya7mass  ");

	}

	public static User getUser() {
		return UserActionListener.userConnected;
	}

	public static void setUser(User user) {
		userConnected = user;
	}
}

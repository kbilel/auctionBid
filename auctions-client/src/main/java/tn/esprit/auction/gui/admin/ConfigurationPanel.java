package tn.esprit.auction.gui.admin;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;

import tn.esprit.auction.delegate.GestionConfigurationDelegate;
import tn.esprit.auction.domain.Client;
import tn.esprit.auction.domain.Configuration;
import tn.esprit.auction.domain.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ConfigurationPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ConfigurationPanel(final JScrollPane scrollPane ) {
		setBounds(0, 0, 1158, 750);
		setLayout(null);
		
		final JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1158, 750);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreDeTocken = new JLabel("nombre de tocken by inscription ");
		lblNombreDeTocken.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombreDeTocken.setBounds(36, 139, 335, 47);
		panel.add(lblNombreDeTocken);
		
		JLabel label = new JLabel("nombre de tocken by inscription ");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(36, 232, 371, 47);
		panel.add(label);
		
		JLabel lblNombreDeTocken_1 = new JLabel("nombre de tocken by quiz");
		lblNombreDeTocken_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombreDeTocken_1.setBounds(36, 318, 360, 47);
		panel.add(lblNombreDeTocken_1);
		
		final JSpinner spinnerInvit = new JSpinner();
		spinnerInvit.setBounds(469, 139, 206, 47);
		panel.add(spinnerInvit);
		
		final JSpinner spinnerInscri = new JSpinner();
		spinnerInscri.setBounds(469, 232, 206, 47);
		panel.add(spinnerInscri);
		
		final JSpinner spinnerQuiz = new JSpinner();
		spinnerQuiz.setBounds(469, 318, 206, 47);
		panel.add(spinnerQuiz);
		
		JButton btnValidate = new JButton("validate");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Integer quiz=(Integer) spinnerQuiz.getValue();
				Integer inscri=(Integer) spinnerInscri.getValue();
				Integer invit=(Integer) spinnerInvit.getValue();
				if(quiz==null||inscri==null||invit==null)
				{
					JOptionPane.showMessageDialog(panel, "ouuupss try Again champs Vide");
				}
				else
				{
					Configuration configuration = new Configuration();
					configuration.setNbrTokenParInscription(inscri);
					configuration.setNbrTokenParInvitation(invit);
					
					List<Configuration> configurations =new ArrayList<Configuration>();
					if(configurations!=null)
					{for (Configuration conf : configurations) {
						GestionConfigurationDelegate.doDeleteConfiguration(conf);
						
					}
					}
					GestionConfigurationDelegate.doAddConfiguration(configuration);
					JOptionPane.showMessageDialog(panel, "goood");
					scrollPane.setViewportView(new HomeAdmin( scrollPane));
					
				}
			}
		});
		btnValidate.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnValidate.setBounds(371, 480, 161, 55);
		panel.add(btnValidate);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ConfigurationPanel.class.getResource("/tn/esprit/auction/gui/admin/back1Config.jpg")));
		lblNewLabel.setBounds(0, 0, 1158, 850);
		panel.add(lblNewLabel);

	}
}

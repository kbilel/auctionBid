package tn.esprit.auction.gui.manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddAuction extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblH;
	private JLabel lblM;
	private JLabel label;
	private JLabel lblEndTime;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel lblStartingPrice;
	private JTextField textField_6;
	private JLabel lblTd;
	private JPanel panel_1;
	private JComboBox comboBox;
	private JLabel lblType;
	private JButton button;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAuction frame = new AddAuction();
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
	public AddAuction() {
		setTitle("Add Auction");
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Add Auction", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 72, 514, 139);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Starting Time :");
		lblNewLabel.setBounds(10, 36, 112, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(132, 33, 28, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(193, 33, 28, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(252, 33, 28, 20);
		panel.add(textField_2);
		
		lblH = new JLabel("m   :");
		lblH.setBounds(170, 33, 27, 20);
		panel.add(lblH);
		
		lblM = new JLabel("s  :");
		lblM.setBounds(229, 33, 27, 20);
		panel.add(lblM);
		
		label = new JLabel("h   :");
		label.setBounds(104, 33, 27, 20);
		panel.add(label);
		
		lblEndTime = new JLabel("End Time :");
		lblEndTime.setBounds(10, 72, 112, 14);
		panel.add(lblEndTime);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(132, 69, 28, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(193, 69, 28, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(252, 69, 28, 20);
		panel.add(textField_5);
		
		label_2 = new JLabel("m   :");
		label_2.setBounds(170, 69, 27, 20);
		panel.add(label_2);
		
		label_3 = new JLabel("s  :");
		label_3.setBounds(229, 69, 27, 20);
		panel.add(label_3);
		
		label_4 = new JLabel("h   :");
		label_4.setBounds(104, 69, 27, 20);
		panel.add(label_4);
		
		lblStartingPrice = new JLabel("Starting Price :");
		lblStartingPrice.setBounds(10, 100, 112, 14);
		panel.add(lblStartingPrice);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(132, 97, 89, 20);
		panel.add(textField_6);
		
		lblTd = new JLabel("TD");
		lblTd.setBounds(229, 100, 27, 20);
		panel.add(lblTd);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Auction Type", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 250, 514, 65);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(132, 28, 188, 20);
		panel_1.add(comboBox);
		
		lblType = new JLabel("Type :");
		lblType.setBounds(10, 31, 112, 14);
		panel_1.add(lblType);
		
		button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {setVisible(false);
				ConvertProductToAuction convertProductToAuction=new ConvertProductToAuction();
				convertProductToAuction.setVisible(true);
				
				
			}
		});
		button.setBounds(296, 427, 89, 23);
		contentPane.add(button);
		
		button_1 = new JButton("Next");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEnglishAuction frame = new AddEnglishAuction();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		button_1.setBounds(435, 427, 89, 23);
		contentPane.add(button_1);
	}
}

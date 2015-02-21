package tn.esprit.auction.gui.admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuestionQUIZ extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public QuestionQUIZ() {
		setBounds(0, 0, 1158, 800);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1158, 800);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 248, 220));
		panel_1.setBounds(78, 26, 917, 180);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblQuestion = new JLabel("Question :");
		lblQuestion.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQuestion.setBounds(10, 11, 122, 30);
		panel_1.add(lblQuestion);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 52, 840, 74);
		panel_1.add(textPane);
		
		JButton btnAddQuestion = new JButton("add Question");
		btnAddQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			}
		});
		btnAddQuestion.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddQuestion.setBounds(384, 137, 156, 32);
		panel_1.add(btnAddQuestion);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 250, 205));
		panel_2.setBounds(78, 257, 917, 431);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("reponse 1: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 90, 146, 37);
		panel_2.add(lblNewLabel);
		
		JLabel lblAnswers = new JLabel("       answers :");
		lblAnswers.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAnswers.setBounds(255, 11, 171, 37);
		panel_2.add(lblAnswers);
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBounds(189, 90, 27, 37);
		panel_2.add(radioButton);
		
		textField = new JTextField();
		textField.setBounds(232, 90, 590, 37);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("reponse 1: ");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(10, 182, 146, 37);
		panel_2.add(label);
		
		JLabel lblAnswer = new JLabel("answer 3 :");
		lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAnswer.setBounds(10, 295, 146, 37);
		panel_2.add(lblAnswer);
		
		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(189, 182, 27, 37);
		panel_2.add(radioButton_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(232, 297, 590, 37);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(232, 182, 590, 37);
		panel_2.add(textField_2);
		
		JRadioButton radioButton_2 = new JRadioButton("");
		radioButton_2.setBounds(189, 295, 27, 37);
		panel_2.add(radioButton_2);
		
		JButton btnValidateAnswers = new JButton("validate answers");
		btnValidateAnswers.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnValidateAnswers.setBounds(143, 383, 244, 37);
		panel_2.add(btnValidateAnswers);

	}
}

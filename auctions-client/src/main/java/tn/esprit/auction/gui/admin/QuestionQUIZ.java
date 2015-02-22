package tn.esprit.auction.gui.admin;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

import tn.esprit.auction.delegate.GestionAnswerDelegate;
import tn.esprit.auction.delegate.GestionQuestionDelegate;
import tn.esprit.auction.delegate.GestionUserDelegate;
import tn.esprit.auction.domain.Answer;
import tn.esprit.auction.domain.Client;
import tn.esprit.auction.domain.Question;
import tn.esprit.auction.domain.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.ImageIcon;

public class QuestionQUIZ extends JPanel {
	private JTextField tfReponse1;
	private JTextField tfreponse3;
	private JTextField tfReponse2;
	private Integer compteur=0;
	private Integer test=0;
	private Integer testAnswer=0;

	/**
	 * Create the panel.
	 */
	public QuestionQUIZ(final JScrollPane scrollPane) {
		setBounds(0, 0, 1158, 800);
		setLayout(null);
		
		final JPanel panel = new JPanel();
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
		
		final JTextPane tfQuestion = new JTextPane();
		tfQuestion.setBounds(10, 52, 840, 74);
		panel_1.add(tfQuestion);
		
		final JPanel panel_2 = new JPanel();
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
		
		final JRadioButton radioButtonReponse1 = new JRadioButton("");
		radioButtonReponse1.setBounds(189, 90, 27, 37);
		panel_2.add(radioButtonReponse1);
		
		tfReponse1 = new JTextField();
		tfReponse1.setBounds(232, 90, 590, 37);
		panel_2.add(tfReponse1);
		tfReponse1.setColumns(10);
		
		JLabel label = new JLabel("reponse 1: ");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(10, 182, 146, 37);
		panel_2.add(label);
		
		JLabel lblAnswer = new JLabel("answer 3 :");
		lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAnswer.setBounds(10, 295, 146, 37);
		panel_2.add(lblAnswer);
		
		final JRadioButton radioButtonReponse2 = new JRadioButton("");
		radioButtonReponse2.setBounds(189, 182, 27, 37);
		panel_2.add(radioButtonReponse2);
		
		tfreponse3 = new JTextField();
		tfreponse3.setColumns(10);
		tfreponse3.setBounds(232, 297, 590, 37);
		panel_2.add(tfreponse3);
		
		tfReponse2 = new JTextField();
		tfReponse2.setColumns(10);
		tfReponse2.setBounds(232, 182, 590, 37);
		panel_2.add(tfReponse2);
		
		
		final JRadioButton radioButtonReponse3 = new JRadioButton("");
		radioButtonReponse3.setBounds(189, 295, 27, 37);
		panel_2.add(radioButtonReponse3);
		panel_2.setVisible(false);
		 tfReponse1.setVisible(false);
			tfReponse2.setVisible(false);
			tfreponse3.setVisible(false);
			radioButtonReponse1.setVisible(false);
			radioButtonReponse2.setVisible(false);
			radioButtonReponse3.setVisible(false);
		
		JButton btnAddQuestion = new JButton("add Question");
		btnAddQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Question question = new Question();
				question.setText(tfQuestion.getText());
				if(tfQuestion.getText().equals(""))
				{
					JOptionPane.showMessageDialog(panel, "ouuupss try again champ vide");
				}
				else 
				{
					if(compteur==0)
		            {GestionQuestionDelegate.doAddQuestion(question);
		            
		            panel_2.setVisible(true);
		   		 tfReponse1.setVisible(true);
		   			tfReponse2.setVisible(true);
		   			tfreponse3.setVisible(true);
		   			radioButtonReponse1.setVisible(true);
					radioButtonReponse2.setVisible(true);
					radioButtonReponse3.setVisible(true);
		            compteur++;}
					else
						JOptionPane.showMessageDialog(panel, "euu you have already add a question ");
				}
	
			}
		});
		btnAddQuestion.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddQuestion.setBounds(384, 137, 156, 32);
		panel_1.add(btnAddQuestion);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(QuestionQUIZ.class.getResource("/tn/esprit/auction/gui/admin/backQuiz.jpg")));
		label_3.setBounds(0, 0, 1158, 850);
		panel_1.add(label_3);
		
		
		
		JButton btnValidateAnswers = new JButton("validate answers");
		btnValidateAnswers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButtonReponse1.isSelected()==false)
					test=1;
				if(radioButtonReponse2.isSelected()==false)
					test++;
				if(radioButtonReponse1.isSelected()==false)
					test++;
				if(radioButtonReponse1.isSelected()==false && radioButtonReponse2.isSelected()==false && radioButtonReponse3.isSelected()==true )
					test=1;
				System.out.println("test="+test);
				if(tfReponse1.getText().equals("")||tfReponse2.getText().equals("")||tfreponse3.getText().equals("")|| test==3)
				{
					JOptionPane.showMessageDialog(panel, "euu you have to put answers correctly ");
					
				}
				else 
				{Question question;
					List<Question> questions = GestionQuestionDelegate.doFindAllQuestions();
						
					if(questions!=null)
					{ 
						
						question=questions.get((questions.size()-1));
						Answer answer1=new Answer();
						Answer answer2=new Answer();
						Answer answer3=new Answer();
						answer1.setQuestion(question);
						answer2.setQuestion(question);
						answer3.setQuestion(question);
						answer1.setText(tfReponse1.getText());
						answer2.setText(tfReponse2.getText());
						answer3.setText(tfreponse3.getText());
						if(GestionAnswerDelegate.doAddAnswer(answer1) && GestionAnswerDelegate.doAddAnswer(answer2)  && GestionAnswerDelegate.doAddAnswer(answer3))
						{testAnswer=1;
							JOptionPane.showMessageDialog(panel, "good question addedd successfully ");
							 scrollPane.setViewportView(new HomeAdmin(scrollPane));
						}
						
				
					}
					
					
				}
				
			}
		});
		btnValidateAnswers.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnValidateAnswers.setBounds(143, 383, 244, 37);
		panel_2.add(btnValidateAnswers);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(QuestionQUIZ.class.getResource("/tn/esprit/auction/gui/admin/backQuiz.jpg")));
		label_1.setBounds(0, 0, 1158, 750);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(QuestionQUIZ.class.getResource("/tn/esprit/auction/gui/admin/backQuiz.jpg")));
		label_2.setBounds(0, 0, 1158, 750);
		panel.add(label_2);

	}
}

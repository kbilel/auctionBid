package tn.esprit.auction.gui.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import tn.esprit.auction.delegate.GestionAnswerDelegate;
import tn.esprit.auction.delegate.GestionQuestionDelegate;
import tn.esprit.auction.domain.Answer;
import tn.esprit.auction.domain.Question;

public class ListQuestionPanel extends JPanel {
	private JTable table;
	private JTable tablequestions;

	Question question=null;

	/**
	 * Create the panel.
	 */
	public ListQuestionPanel() {
		setBounds(0, 0, 1800, 750);
		
		setBackground(new Color(248, 248, 255));
		setLayout(null);
		
		final JPanel panelquestion = new JPanel();
		panelquestion.setBackground(new Color(250, 250, 210));
		panelquestion.setBounds(0, 0, 1800, 750);
		add(panelquestion);
		panelquestion.setLayout(null);
		
		
		tablequestions = new JTable();
		tablequestions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int row = tablequestions.getSelectedRow();
			        
			      // String  name=tablequestions.getModel().getValueAt(row,0).toString();
			        String idd=tablequestions.getModel().getValueAt(row,0).toString();
			        int id=Integer.parseInt(idd);
			        question= GestionQuestionDelegate.doFindQuestionById(id);
			        
			       
			}
		});
		tablequestions.setFont(new Font("Tahoma", Font.BOLD, 15));
		tablequestions.setBackground(new Color(253, 245, 230));
		tablequestions.setBounds(544, 122, 586, 406);
		tablequestions.setModel(new ListQuestion());
		panelquestion.add(tablequestions);
		
		
		
		JButton btnDelete = new JButton("delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(question!=null)
				{ Answer answer = new Answer();
					
					GestionAnswerDelegate.doDeleteAnswer(answer);
					if(GestionQuestionDelegate.doDeleteQuestion(question))
				{
					question=null;
					
					
					tablequestions.setModel(new ListQuestion());
				    panelquestion.add(tablequestions);
				}}
				else 
				{
					JOptionPane.showMessageDialog(panelquestion, "ouuupss you have to choose a question to delete ");
				
				
				}
			}
		});
		btnDelete.setBounds(248, 551, 246, 51);
		panelquestion.add(btnDelete);
		
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ListQuestionPanel.class.getResource("/tn/esprit/auction/gui/client/back.jpg")));
		label.setBounds(0, 0, 1800,750);
		panelquestion.add(label);

	}

}

package tn.esprit.auction.gui.admin;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import tn.esprit.auction.delegate.GestionQuestionDelegate;
import tn.esprit.auction.delegate.GestionUserDelegate;
import tn.esprit.auction.domain.Client;
import tn.esprit.auction.domain.Question;
import tn.esprit.auction.domain.User;

public class ListQuestion extends AbstractTableModel{
	String [] header={"id","Text"};
	
    List<Question> questions=new ArrayList<Question>();

	public ListQuestion() {
		questions=GestionQuestionDelegate.doFindAllQuestions();
		
		
		System.out.println("nombre client="+questions.size());
	} @Override
    public String getColumnName(int column) {
        return header[column];
    }

	@Override
	public int getRowCount() {
		 return questions.size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
        case 0: 
            return questions.get(rowIndex).getId();
        case 1: 
            return questions.get(rowIndex).getText();
  
            
        default:
            return null;
    }
	}

}

package tn.esprit.auction.gui.admin;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import tn.esprit.auction.delegate.GestionUserDelegate;
import tn.esprit.auction.domain.Client;
import tn.esprit.auction.domain.User;

public class ListClient extends AbstractTableModel{
	String [] header={"id","name", "login","password","adresse","email"};
	
    List<Client> clients=new ArrayList<Client>();

	public ListClient() {
		List<User> users=GestionUserDelegate.doFindAllUsers();
		for (User user : users) {
			if(user instanceof Client)
			{
				clients.add((Client)user);	}
			
		}
	} @Override
    public String getColumnName(int column) {
        return header[column];
    }
	public int getRowCount() {
		 return clients.size();
	}
	public int getColumnCount() {
		return header.length;
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
	case 0: 
        return clients.get(rowIndex).getId();
    case 1: 
        return clients.get(rowIndex).getFullName();
    case 2: 
        return clients.get(rowIndex).getUserName();
        
        case 3: 
        return clients.get(rowIndex).getAdress();
            
    case 4: 
        return clients.get(rowIndex).getEmail();
        
    default:
        return null;
	}
	}

	/*@Override
	public int getRowCount() {
		 return clients.size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
        case 0: 
            return clients.get(rowIndex).getId();
        case 1: 
            return clients.get(rowIndex).getFullName();
        case 2: 
            return clients.get(rowIndex).getUserName();
            
            case 3: 
            return clients.get(rowIndex).getAdress();
                
        case 4: 
            return clients.get(rowIndex).getEmail();
            
        default:
            return null;
    }  
	}*/

}

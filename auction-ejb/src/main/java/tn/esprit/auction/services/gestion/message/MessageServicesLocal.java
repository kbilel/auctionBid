package tn.esprit.auction.services.gestion.message;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.auction.domain.Message;

@Local
public interface MessageServicesLocal {
	Boolean addMessage(Message message );
	Boolean updateMessage(Message message);
	Boolean deleteMessage(Message message);
	Message findMessageById(Integer idMessage);
	List<Message>findAllMessages();
	
}

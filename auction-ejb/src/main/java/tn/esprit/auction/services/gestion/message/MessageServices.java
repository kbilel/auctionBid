package tn.esprit.auction.services.gestion.message;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.auction.domain.Message;

/**
 * Session Bean implementation class MessageServices
 */
@Stateless
@LocalBean
public class MessageServices implements MessageServicesRemote, MessageServicesLocal {


	@PersistenceContext(unitName="auction-ejb")
	EntityManager entityManager;
    public MessageServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addMessage(Message message) {
		try {
			entityManager.persist(message);
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Boolean updateMessage(Message message) {
		try {
			entityManager.merge(message);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteMessage(Message message) {
		try {
			
			
			entityManager.remove(entityManager.merge(message));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Message findMessageById(Integer idMessage) {
		Message message=null;
		try {
			message=entityManager.find(Message.class, idMessage);
		
		} catch (Exception e) {
			
		}
		return message;
	}

	@Override
	public List<Message> findAllMessages() {
		Query query=entityManager.createQuery("select m from Message m ");
		return query.getResultList();
	}

	

}

package service;

import dao.MessageDao;
import domain.Message;


public class MessageService {

	private MessageDao messageDao = new MessageDao();
	
	public void addMessage(Message message) throws MessageException{
		
		messageDao.add(message);
		
	}
	
	public String getAllMessages(String username){
		return messageDao.getAllMessages(username);
		
	}

}

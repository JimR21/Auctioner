package com.ted.service;

import java.util.List;

import com.ted.model.Message;
import com.ted.model.User;

public interface MessageService {
	
	List<Message> getByReceiver(User receiver);
	
	List<Message> getBySender(User sender);
	
	Message getById(Integer id);
	
	boolean isMessageOwner(String username, Message message);
	
	void messageIsRead(Message message);

}

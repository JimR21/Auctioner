package com.ted.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ted.model.Message;
import com.ted.model.User;
import com.ted.repository.MessageRepository;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	MessageRepository messageRepository;

	public List<Message> getByReceiver(User receiver) {
		
		return messageRepository.findByReceiver(receiver);
		
	}

	public List<Message> getBySender(User sender) {

		return messageRepository.findBySender(sender);
		
	}

	public Message getById(Integer id) {
		
		return messageRepository.findByMessageId(id);
		
	}

	public boolean isMessageOwner(String username, Message message) {
		
		if(username.equals(message.getSender().getUsername()) || username.equals(message.getReceiver().getUsername()))
			return true;
		
		return false;
		
	}

	@Transactional
	public void messageIsRead(Message message) {
		
		message.setIsRead((byte)1);
		
		messageRepository.saveAndFlush(message);
		
	}
	
	

}

package com.ted.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ted.model.GlobalMessage;
import com.ted.model.Message;
import com.ted.model.User;
import com.ted.repository.GlobalMessageRepository;
import com.ted.repository.MessageRepository;
import com.ted.repository.UserRepository;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	GlobalMessageRepository globalMessageRepository;
	
	@Autowired
	UserRepository userRepository;

	public List<Message> getByReceiver(User receiver) {
		
		return messageRepository.findByReceiverOrderByDateDesc(receiver);
		
	}

	public List<Message> getBySender(User sender) {

		return messageRepository.findBySenderOrderByDateDesc(sender);
		
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

	@Transactional
	public String saveMessage(Message message) {
		
		User receiver = userRepository.findByUsername(message.getReceiver().getUsername());
		User sender = null;
		
		if(receiver == null)
			return "Username doesn't exist";
		
		// TODO: Extra input check
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String username = authentication.getName();
		    sender = userRepository.findByUsername(username);
		}
		
		message.setReceiver(receiver);
		message.setSender(sender);
		
		messageRepository.saveAndFlush(message);	
		
		return null;
	}

	@Transactional
	public void saveGlobalMessage(GlobalMessage message) {
		
		globalMessageRepository.saveAndFlush(message);
		
	}

	public List<GlobalMessage> getAllGlobalMessages() {
		
		return globalMessageRepository.findAll();
		
	}

	public Integer checkNewMessages() {
		
		User user = null;

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String username = authentication.getName();
		    user = userRepository.findByUsername(username);
		}
		
		return messageRepository.newMessagesCount(user.getUserid());
		
	}
	
	

}

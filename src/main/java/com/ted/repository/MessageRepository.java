package com.ted.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ted.model.Message;
import com.ted.model.User;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
	
	List<Message> findByReceiver(User receiver);
	
	List<Message> findBySender(User sender);
	
	Message findByMessageId(int id);

}

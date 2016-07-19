package com.ted.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ted.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	

}

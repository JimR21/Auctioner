package com.ted.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ted.model.Auction;
import com.ted.model.Similar;
import com.ted.model.SimilarPK;
import com.ted.model.User;

public interface SimilarRepository extends JpaRepository<Similar, SimilarPK> {
	
	List<Similar> findByUser1(User user);

}

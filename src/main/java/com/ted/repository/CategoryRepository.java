package com.ted.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ted.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	Category findByName(String name);

}

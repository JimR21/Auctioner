package com.ted.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ted.model.UserPicture;

public interface UserPictureRepository extends JpaRepository<UserPicture, Long> {

}

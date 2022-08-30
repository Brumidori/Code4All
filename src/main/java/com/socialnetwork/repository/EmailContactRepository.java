package com.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialnetwork.model.EmailContact;

@Repository
public interface EmailContactRepository extends JpaRepository< EmailContact, Long> {
  
}
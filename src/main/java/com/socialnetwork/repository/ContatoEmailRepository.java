package com.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialnetwork.model.ContatoEmail;

@Repository
public interface ContatoEmailRepository extends JpaRepository< ContatoEmail, Long> {
  
}
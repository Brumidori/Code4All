package com.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialnetwork.model.ContactEmail;

@Repository
public interface ContactEmailRepository extends JpaRepository<ContactEmail, Long> {

}

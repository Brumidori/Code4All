package com.socialnetwork.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.socialnetwork.model.UserDetails;


public interface UserDetailsRepository extends JpaRepository <UserDetails, Long>{
	public List<UserDetails> findAllByNameContainingIgnoreCase(@Param("name") String name);
	public List<UserDetails> findAllByDocumentContainingIgnoreCase(@Param("document") String document);
}

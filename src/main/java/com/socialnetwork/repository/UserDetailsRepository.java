package com.socialnetwork.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.socialnetwork.model.Profile;


public interface UserDetailsRepository extends JpaRepository <Profile, Long>{
	public List<Profile> findAllByNameContainingIgnoreCase(@Param("name") String name);
	public List<Profile> findAllByDocumentContainingIgnoreCase(@Param("document") String document);
}

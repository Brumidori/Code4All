package com.socialnetwork.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.socialnetwork.model.profile;


public interface ProfileRepository extends JpaRepository <profile, Long>{
	//public List<profile> findAllByNameContainingIgnoreCase(@Param("name") String name);
	public List<profile> findAllByDocumentContainingIgnoreCase(@Param("document") String document);
}

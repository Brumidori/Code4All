package com.socialnetwork.repository;

import java.util.List;

import com.socialnetwork.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;



public interface ProfileRepository extends JpaRepository <Profile, Long>{
	public List<Profile> findAllByNameContainingIgnoreCase(@Param("name") String name);
	public List<Profile> findAllByDocumentContainingIgnoreCase(@Param("document") String document);
}

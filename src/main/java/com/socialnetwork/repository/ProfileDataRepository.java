package com.socialnetwork.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.socialnetwork.model.ProfileData;

public interface ProfileDataRepository extends JpaRepository<ProfileData, Long>{
	public List<ProfileData> findAllByNicknameContainingIgnoreCase(@Param("nickname") String nickname);
}

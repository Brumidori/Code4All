package com.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialnetwork.model.BlockedUser;

@Repository
public interface BlockedUserRepository extends JpaRepository<BlockedUser, Long>{

}

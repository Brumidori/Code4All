package com.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialnetwork.model.LikePost;


public interface LikePostRepository extends JpaRepository<LikePost, Long>{

}

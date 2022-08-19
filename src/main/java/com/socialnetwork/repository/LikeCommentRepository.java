package com.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialnetwork.model.LikeComment;

public interface LikeCommentRepository extends JpaRepository<LikeComment, Long>{

}

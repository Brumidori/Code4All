package com.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialnetwork.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}

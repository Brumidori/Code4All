package com.socialnetwork.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.socialnetwork.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	public List<Post> findAllByTituloContainingIgnoreCase(@Param("titulo")String titulo);
}

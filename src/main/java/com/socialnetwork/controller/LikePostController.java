package com.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.model.LikePost;
import com.socialnetwork.repository.LikePostRepository;

@RestController
@RequestMapping("/like-post")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LikePostController {

	@Autowired
	private LikePostRepository likePostRepository;
	
	@GetMapping
	public ResponseEntity<List<LikePost>> getAll(){
		return ResponseEntity.ok(likePostRepository.findAll());
	}
}

package com.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.model.Followers;
import com.socialnetwork.repository.FollowersRepository;

@RestController
@RequestMapping ("/followers")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class FollowersController {
	
	@Autowired
	private FollowersRepository followersRepository;
	
	@GetMapping
	public ResponseEntity<List<Followers>> getAll(){
		return ResponseEntity.ok(followersRepository .findAll());
	}

}

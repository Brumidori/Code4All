package com.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.socialnetwork.repository.EmailContactRepository;

@RestController
@RequestMapping ("/emailContact")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class EmailContactController {
	
	@Autowired
	private EmailContactRepository emailContactRepository;
	
	@GetMapping
	public ResponseEntity<List<com.socialnetwork.model.EmailContact>> getAll(){
		return ResponseEntity.ok(emailContactRepository.findAll());
	}
	
}

package com.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.model.ContactEmail;
import com.socialnetwork.repository.ContactEmailRepository;

@RestController
@RequestMapping ("/ContactEmail")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class ContactEmailController {

	@Autowired
	private ContactEmailRepository contactEmailRepository;
	
	@GetMapping
	public ResponseEntity<List<ContactEmail>> getAll(){
		return ResponseEntity.ok(contactEmailRepository.findAll());
	}
}

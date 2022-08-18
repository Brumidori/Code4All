package com.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.model.Adress;
import com.socialnetwork.repository.AdressRepository;

@RestController
@RequestMapping("/adress")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdressController {
	
	@Autowired
	private AdressRepository adressRepository;
	
	@GetMapping
	public ResponseEntity<List<Adress>>getAll(){
		return ResponseEntity.ok(adressRepository.findAll());
	}
}

package com.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.model.City;
import com.socialnetwork.repository.CityRepository;

@RestController
@RequestMapping("/city")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CityController {
	
	@Autowired
	private CityRepository cityRepository;
	
	@GetMapping
	public ResponseEntity<List<City>>getAll(){
		return ResponseEntity.ok(cityRepository.findAll());
	}

}	
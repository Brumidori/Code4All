package com.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.model.TypeRoad;
import com.socialnetwork.repository.TypeRoadRepository;

@RestController
@RequestMapping("/road")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TypeRoadController {

	@Autowired
	private TypeRoadRepository typeRoadRepository;
	
	@GetMapping
	public ResponseEntity<List<TypeRoad>>getAll(){
		return ResponseEntity.ok(typeRoadRepository.findAll());
	}
}

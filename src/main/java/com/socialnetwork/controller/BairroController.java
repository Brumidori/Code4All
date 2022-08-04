package com.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.model.Bairro;
import com.socialnetwork.repository.BairroRepository;

@RestController
@RequestMapping("/bairro")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BairroController {

	@Autowired
	private BairroRepository bairroRepository;
	
	@GetMapping
	public ResponseEntity<List<Bairro>>getAll(){
		return ResponseEntity.ok(bairroRepository.findAll());
	}
}

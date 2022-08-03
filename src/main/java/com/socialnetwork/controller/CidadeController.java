package com.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.model.Cidade;
import com.socialnetwork.repository.CidadeRepository;

@RestController
@RequestMapping("/cidade")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CidadeController {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@GetMapping
	public ResponseEntity<List<Cidade>>getAll(){
		return ResponseEntity.ok(cidadeRepository.findAll());
	}

}	
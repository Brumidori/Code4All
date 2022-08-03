package com.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.model.Endereco;
import com.socialnetwork.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping
	public ResponseEntity<List<Endereco>>getAll(){
		return ResponseEntity.ok(enderecoRepository.findAll());
	}
}

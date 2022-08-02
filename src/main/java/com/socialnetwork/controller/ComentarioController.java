package com.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.model.Comentario;
import com.socialnetwork.repository.ComentarioRepository;

@RestController
@RequestMapping("/comentario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ComentarioController {

	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@GetMapping
	public ResponseEntity<List<Comentario>> getAll(){
		return ResponseEntity.ok(comentarioRepository.findAll());
	}
}

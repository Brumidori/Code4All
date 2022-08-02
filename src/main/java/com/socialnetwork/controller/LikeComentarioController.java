package com.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.model.LikeComentario;
import com.socialnetwork.repository.LikeComentarioRepository;

@RestController
@RequestMapping("/like-comentario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LikeComentarioController {

	@Autowired
	private LikeComentarioRepository LikeComentarioRepository;
	
	@GetMapping
	public ResponseEntity<List<LikeComentario>> getAll(){
		return ResponseEntity.ok(LikeComentarioRepository.findAll());
	}
}

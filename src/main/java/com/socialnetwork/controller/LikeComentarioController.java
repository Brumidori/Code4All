package com.socialnetwork.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.socialnetwork.model.LikeComentario;
import com.socialnetwork.repository.LikeComentarioRepository;

@RestController
@RequestMapping("/like-comentario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LikeComentarioController {

	@Autowired
	private LikeComentarioRepository likeComentarioRepository;
	
	@GetMapping
	public ResponseEntity<List<LikeComentario>> getAll(){
		return ResponseEntity.ok(likeComentarioRepository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<LikeComentario> getById(@PathVariable long id){
		return likeComentarioRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta)).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
	}	
		
	@PostMapping
	public ResponseEntity<LikeComentario> post(@Valid @RequestBody LikeComentario likeComentario){
		return ResponseEntity.status(HttpStatus.CREATED).body(likeComentarioRepository.save(likeComentario));
	}
	
	@PutMapping
	public ResponseEntity<LikeComentario> put(@Valid @RequestBody LikeComentario likeComentario){
		return likeComentarioRepository.findById(likeComentario.getId()).map(resposta -> ResponseEntity.status(HttpStatus.OK).body(likeComentarioRepository.save(likeComentario))).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		Optional<LikeComentario> likeComentario = likeComentarioRepository.findById(id);
		
		if(likeComentario.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		likeComentarioRepository.deleteById(id);
	}
}

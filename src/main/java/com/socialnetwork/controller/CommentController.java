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


import com.socialnetwork.model.Comment;
import com.socialnetwork.repository.CommentRepository;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommentController {

	@Autowired
	private CommentRepository commentRepository;
	
	@GetMapping
	public ResponseEntity<List<Comment>> getAll(){
		return ResponseEntity.ok(commentRepository.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Comment> getById(@PathVariable Long id){
		return commentRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta)).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
	}	
	
	
	@PostMapping
	public ResponseEntity<Comment> post(@Valid @RequestBody Comment comment){
		return ResponseEntity.status(HttpStatus.CREATED).body(commentRepository.save(comment));
	}
	
	@PutMapping
	public ResponseEntity<Comment> put(@Valid @RequestBody Comment comment, @PathVariable Long id){
		return commentRepository.findById(id).map(resposta -> ResponseEntity.status(HttpStatus.OK).body(commentRepository.save(comment))).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Comment> comment = commentRepository.findById(id);
		
		if(comment.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		commentRepository.deleteById(id);
	}
}

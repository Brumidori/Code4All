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

import com.socialnetwork.model.LikeComment;
import com.socialnetwork.repository.LikeCommentRepository;

@RestController
@RequestMapping("/like-comment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LikeCommentController {

	@Autowired
	private LikeCommentRepository likeCommentRepository;
	
	@GetMapping
	public ResponseEntity<List<LikeComment>> getAll(){
		return ResponseEntity.ok(likeCommentRepository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<LikeComment> getById(@PathVariable Long id){
		return likeCommentRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta)).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
	}	
		
	@PostMapping
	public ResponseEntity<LikeComment> post(@Valid @RequestBody LikeComment likeComment){
		return ResponseEntity.status(HttpStatus.CREATED).body(likeCommentRepository.save(likeComment));
	}
	
	@PutMapping
	public ResponseEntity<LikeComment> put(@PathVariable Long id, @Valid @RequestBody LikeComment likeComment){
		return likeCommentRepository.findById(id).map(resposta -> ResponseEntity.status(HttpStatus.OK).body(likeCommentRepository.save(likeComment))).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<LikeComment> likeComment = likeCommentRepository.findById(id);
		
		if(likeComment.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		likeCommentRepository.deleteById(id);
	}
}

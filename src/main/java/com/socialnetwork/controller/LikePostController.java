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

import com.socialnetwork.model.LikePost;
import com.socialnetwork.repository.LikePostRepository;

@RestController
@RequestMapping("/like-post")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LikePostController {

	@Autowired
	private LikePostRepository likePostRepository;
	
	@GetMapping
	public ResponseEntity<List<LikePost>> getAll(){
		return ResponseEntity.ok(likePostRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LikePost> getById(@PathVariable long id){
		return likePostRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta)).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
	}	
		
	@PostMapping
	public ResponseEntity<LikePost> post(@Valid @RequestBody LikePost likePost){
		return ResponseEntity.status(HttpStatus.CREATED).body(likePostRepository.save(likePost));
	}
	
	@PutMapping
	public ResponseEntity<LikePost> put(@Valid @RequestBody LikePost likePost){
		return likePostRepository.findById(likePost.getId()).map(resposta -> ResponseEntity.status(HttpStatus.OK).body(likePostRepository.save(likePost))).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		Optional<LikePost> likePost = likePostRepository.findById(id);
		
		if(likePost.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		likePostRepository.deleteById(id);
	}
}

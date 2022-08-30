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

import com.socialnetwork.model.BlockedUser;
import com.socialnetwork.repository.BlockedUserRepository;

@RestController
@RequestMapping ("/blockedUser")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BlockedUserController {

	@Autowired
	private BlockedUserRepository blockedUserRepository;
	
	@GetMapping
	public ResponseEntity<List<BlockedUser>> getAll(){
		return ResponseEntity.ok(blockedUserRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BlockedUser> getById(@PathVariable Long id) {
		return blockedUserRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@PostMapping
	public ResponseEntity<@Valid BlockedUser> post(@Valid @RequestBody BlockedUser blockedUser){
		return ResponseEntity.status(HttpStatus.CREATED).body(blockedUserRepository.save(blockedUser));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BlockedUser> put(@PathVariable Long id, @Valid @RequestBody BlockedUser blockedUser){
		return blockedUserRepository.findById(id).map(resposta -> ResponseEntity.status(HttpStatus.OK)
				.body(blockedUserRepository.save(blockedUser)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); 
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<BlockedUser> user = blockedUserRepository.findById(id);
		
		if(user.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		blockedUserRepository.deleteById(id);
	}
}

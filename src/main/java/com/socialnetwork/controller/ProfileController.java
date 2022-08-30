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

import com.socialnetwork.model.profile;
import com.socialnetwork.repository.ProfileRepository;


@RestController
@RequestMapping ("/profile")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class ProfileController {

	@Autowired
	private ProfileRepository profileRepository;
	
	@GetMapping
	public ResponseEntity<List<profile>> getAll(){
		return ResponseEntity.ok(profileRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<profile> getById(@PathVariable Long id){
		return profileRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
	}
	
//	@GetMapping("/nome/{nome}")
//	public ResponseEntity<List<profile>> getByNome(@PathVariable String name){
//		return ResponseEntity.ok(profileRepository.findAllByNameContainingIgnoreCase(name));
//	}

	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<List<profile>> getByCpf(@PathVariable String document){
		return ResponseEntity.ok(profileRepository.findAllByDocumentContainingIgnoreCase(document));
	}
	
	@PostMapping
	public ResponseEntity<profile> post(@Valid @RequestBody profile profile){
		return ResponseEntity.status(HttpStatus.CREATED).body(profileRepository.save(profile));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<profile> put(@PathVariable Long id, @Valid @RequestBody profile profile){
		return profileRepository.findById(id).map(resposta -> ResponseEntity.status(HttpStatus.OK)
				.body(profileRepository.save(profile)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); 
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<profile> usuarios = profileRepository.findById(id);
		
		if(usuarios.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		profileRepository.deleteById(id);
	}

}


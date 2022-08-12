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

import com.socialnetwork.model.ProfileData;
import com.socialnetwork.repository.ProfileDataRepository;

@RestController
@RequestMapping("/profileData")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProfileDataController {

	@Autowired
	private ProfileDataRepository profileDataRepository;

	@GetMapping
	public ResponseEntity<List<ProfileData>> getAll() {
		return ResponseEntity.ok(profileDataRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProfileData> getById(@PathVariable Long id) {
		return profileDataRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/apelido/{apelido}")
	public ResponseEntity<List<ProfileData>> getByNickname(@PathVariable String nickname) {
		return ResponseEntity.ok(profileDataRepository.findAllByNicknameContainingIgnoreCase(nickname));
	}

	@PostMapping
	public ResponseEntity<ProfileData> post(@Valid @RequestBody ProfileData profileData) {
		return ResponseEntity.status(HttpStatus.CREATED).body(profileDataRepository.save(profileData));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProfileData> put(@PathVariable Long id, @Valid @RequestBody ProfileData profileData) {
		return profileDataRepository.findById(id)
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(profileDataRepository.save(profileData)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<ProfileData> dadosperfil = profileDataRepository.findById(id);

		if (dadosperfil.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		profileDataRepository.deleteById(id);
	}

}

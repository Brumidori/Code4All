package com.socialnetwork.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tb_state")
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size (min = 3, max = 255)
	private String name_state;
	@NotBlank
	@Size (min = 2, max = 2)
	private String initials_state;

	@OneToMany(mappedBy = "state", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("state")
	private List<City> city;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName_state() {
		return name_state;
	}

	public void setName_state(String name_state) {
		this.name_state = name_state;
	}

	public String getInitials_state() {
		return initials_state;
	}

	public void setInitials_state(String initials_state) {
		this.initials_state = initials_state;
	}

	public List<City> getCity() {
		return city;
	}

	public void setCity(List<City> city) {
		this.city = city;
	}
}

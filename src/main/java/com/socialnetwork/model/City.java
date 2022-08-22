package com.socialnetwork.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Entity
@Table (name = "tb_city")
public class City {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size (min = 5, max = 255)
	private String name_city;
	
	@ManyToOne
	@JsonIgnoreProperties ("City")
	private State state;

	@OneToMany(mappedBy = "city", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("city")
	private List<District> district;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName_city() {
		return name_city;
	}

	public void setName_city(String name_city) {
		this.name_city = name_city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<District> getDistrict() {
		return district;
	}

	public void setDistrict(List<District> district) {
		this.district = district;
	}
}

package com.socialnetwork.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Entity
@Table (name = "tb_road")
public class TypeRoad {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnoreProperties ("TypeRoad")
	private String description;

	@OneToMany(mappedBy = "typeRoad", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("typeRoad")
	private List<Address> addresses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
}

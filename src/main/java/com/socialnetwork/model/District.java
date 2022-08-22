package com.socialnetwork.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Entity
@Table (name = "tb_district")
public class District {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 1, max = 255)
	private String name_district;
	
	@ManyToOne
	@JsonIgnoreProperties("Bairro")
	private City city;

	@OneToMany(mappedBy = "userDetails", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("userDetails")
	private List<Address> addresses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName_district() {
		return name_district;
	}

	public void setName_district(String name_district) {
		this.name_district = name_district;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
}

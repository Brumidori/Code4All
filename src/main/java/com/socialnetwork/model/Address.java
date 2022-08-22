package com.socialnetwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@NotNull
	private Long nr_address;
	
	@NotBlank
	@Size(min = 1, max = 128, message = "Complemento deve ter no mínimo 1 e no máximo 20 caracteres.")
	private String complement;
	
	@ManyToOne
	@JsonIgnoreProperties ("Address")
	private UserDetails userDetails;
	
	@ManyToOne
	@JsonIgnoreProperties ("Address")
	private TypeRoad typeRoad;
	
	@ManyToOne
	@JsonIgnoreProperties ("Address")
	private District district;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNr_address() {
		return nr_address;
	}

	public void setNr_address(Long nr_address) {
		this.nr_address = nr_address;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public TypeRoad getTypeRoad() {
		return typeRoad;
	}

	public void setTypeRoad(TypeRoad typeRoad) {
		this.typeRoad = typeRoad;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
}

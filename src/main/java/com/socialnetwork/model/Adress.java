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
@Table(name = "tb_adress")
public class Adress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_adress;
		
	@NotNull
	private Long nr_adress;
	
	@NotBlank
	@Size(min = 1, max = 128, message = "Complemento deve ter no mínimo 1 e no máximo 20 caracteres.")
	private String complement;
	
	@ManyToOne
	@JsonIgnoreProperties ("Adress")
	private UserDetails userDetails;
	
	@ManyToOne
	@JsonIgnoreProperties ("Adress")
	private TypeRoad typeRoad;
	
	@ManyToOne
	@JsonIgnoreProperties ("Adress")
	private District district;

	public Long getId_adress() {
		return id_adress;
	}

	public void setId_adress(Long id_adress) {
		this.id_adress = id_adress;
	}

	public Long getNr_adress() {
		return nr_adress;
	}

	public void setNr_adress(Long nr_adress) {
		this.nr_adress = nr_adress;
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

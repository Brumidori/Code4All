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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	private Profile profile;

	
	@ManyToOne
	@JsonIgnoreProperties ("Address")
	private TypeRoad typeRoad;
	
	@ManyToOne
	@JsonIgnoreProperties ("Address")
	private District district;

}

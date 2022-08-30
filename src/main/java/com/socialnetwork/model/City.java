package com.socialnetwork.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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


}

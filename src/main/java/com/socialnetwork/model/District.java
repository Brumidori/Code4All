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
@Table (name = "tb_district")
public class District {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 1, max = 255)
	private String name_district;
	
	@ManyToOne
	@JsonIgnoreProperties("district")
	private City city;

	@OneToMany(mappedBy = "district", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("district")
	private List<Address> addresses;

}

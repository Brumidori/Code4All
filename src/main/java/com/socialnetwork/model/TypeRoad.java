package com.socialnetwork.model;

import javax.persistence.*;

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

}

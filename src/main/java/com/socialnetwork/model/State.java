package com.socialnetwork.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}

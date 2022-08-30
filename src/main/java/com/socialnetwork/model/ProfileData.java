package com.socialnetwork.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table (name = "tb_profile_data")

public class ProfileData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@Size(min = 3, max = 255, message = "O nickname deve ter ao menos 3 caracteres.")
	private String nickname;
	
	@Size(min = 5, max = 255)
	private String profilePhoto;
	
	@Size(min = 3, max = 1000, message = "A biografia deve conter de 3 a 1000 caracteres.")
	private String bio;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user_details", referencedColumnName = "id")
	@JsonIgnoreProperties("profileData")
	private Profile profile;

	
}

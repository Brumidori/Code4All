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

@Entity
@Table (name = "tb_profile_data")
public class ProfileData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id_profile_data;
	
	@Size(min = 3, max = 255, message = "O nickname deve ter ao menos 3 caracteres.")
	private String nickname;
	
	@Size(min = 5, max = 255)
	private String profilePhoto;
	
	@Size(min = 3, max = 1000, message = "A biografia deve conter de 3 a 1000 caracteres.")
	private String bio;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user_details", referencedColumnName = "id")
	@JsonIgnoreProperties("profileData")
	private profile profile;

	public Long getId_profile_data() {
		return id_profile_data;
	}

	public void setId_profile_data(Long id_profile_data) {
		this.id_profile_data = id_profile_data;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public profile getUserDetails() {
		return profile;
	}

	public void setUserDetails(profile profile) {
		this.profile = profile;
	}
	
}

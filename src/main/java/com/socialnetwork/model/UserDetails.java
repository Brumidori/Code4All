package com.socialnetwork.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_user_details")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email
	private String email;
	
	@NotBlank(message = "O nome é Obrigatório!") 
	@Size(min = 5, max = 255)
	private String name;
	
	@NotNull(message = "O documento é Obrigatório!") 
	@Size(min = 11, max = 255, message = "O documento deve conter pelo menos 11 digitos.")
	private String document;
	
	@UpdateTimestamp
	private LocalDateTime registration_date;
	
	@Column
	private LocalDate birthDate;
	
	@NotBlank
	private boolean ong;
	
	@NotBlank
	private boolean active;
	
	@NotBlank(message = "O nome de usuário é Obrigatório!") 
	private String username;
	
	@NotBlank(message = "A senha é Obrigatória!") 
	@Size(min = 6, max = 255, message = "A senha deve conter no mínimo 6 digitos.")
	private String password;
	
	@OneToOne(mappedBy = "userDetails")
	@JsonIgnoreProperties("userDetails")
	private ProfileData profileData;
	
	@OneToOne(mappedBy = "userDetails")
	@JsonIgnoreProperties("userDetails")
	private BlockedUser blockedUser;
	
	@OneToMany(mappedBy = "userDetails", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("userDetails")
	private List<Post> post;
	
	@OneToMany(mappedBy = "userDetails", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("userDetails")
	private List<Comment> comment;
	
	@OneToMany(mappedBy = "userDetails", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("userDetails")
	private List<LikePost> likePost;
	
	@OneToMany(mappedBy = "userDetails", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("userDetails")
	private List<LikeComment> likeComment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public LocalDateTime getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(LocalDateTime registration_date) {
		this.registration_date = registration_date;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isOng() {
		return ong;
	}

	public void setOng(boolean ong) {
		this.ong = ong;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ProfileData getProfileData() {
		return profileData;
	}

	public void setProfileData(ProfileData profileData) {
		this.profileData = profileData;
	}

	public BlockedUser getBlockedUser() {
		return blockedUser;
	}

	public void setBlockedUser(BlockedUser blockedUser) {
		this.blockedUser = blockedUser;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public List<LikePost> getLikePost() {
		return likePost;
	}

	public void setLikePost(List<LikePost> likePost) {
		this.likePost = likePost;
	}

	public List<LikeComment> getLikeComment() {
		return likeComment;
	}

	public void setLikeComment(List<LikeComment> likeComment) {
		this.likeComment = likeComment;
	}
	
	
	
}


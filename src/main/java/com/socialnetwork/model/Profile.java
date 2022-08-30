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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "tb_profile")
public class Profile {
	
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
	
	@OneToOne(mappedBy = "profile")
	@JsonIgnoreProperties("profile")
	private ProfileData profileData;
	
	@OneToOne(mappedBy = "profile")
	@JsonIgnoreProperties("profile")
	private BlockedUser blockedUser;
	
	@OneToMany(mappedBy = "profile", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("profile")
	private List<Post> post;
	
	@OneToMany(mappedBy = "profile", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("profile")
	private List<Comment> comment;
	
	@OneToMany(mappedBy = "profile", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("profile")
	private List<LikePost> likePost;
	
	@OneToMany(mappedBy = "profile", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("profile")
	private List<LikeComment> likeComment;

	@OneToMany(mappedBy = "profile", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("profile")
	private List<Address> addresses;

	@OneToMany(mappedBy = "profile", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("profile")
	private List<EmailContact> emailContacts ;

	@OneToMany(mappedBy = "profile", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("profile")
	private List<BlockedUser> blockedUsers ;


}


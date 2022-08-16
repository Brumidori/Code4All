package com.socialnetwork.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_post")
public class Post {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 5000)
	private String text;
	
	@NotBlank
	@Size(min = 3, max = 255)
	private String title;
	
	@UpdateTimestamp
	private LocalDateTime date;
	
	@Size(min = 3, max = 255)
	private String photo;

	@ManyToOne
	@JsonIgnoreProperties("post")
	private UserDetails userDetails;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("post")
	private List<Comment> comment;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	
}

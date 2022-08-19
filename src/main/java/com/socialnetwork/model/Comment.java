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
@Table(name = "tb_comments")
public class Comment {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 255)
	private String textComment;
	
	@UpdateTimestamp
	private LocalDateTime dateComment;

	@ManyToOne
	@JsonIgnoreProperties("comment")
	private Post post;
	
	@ManyToOne
	@JsonIgnoreProperties("comment")
	private UserDetails userDetails;
	
	@OneToMany(mappedBy = "comment", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("comment")
	private List<LikeComment> likeComment;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTextComment() {
		return textComment;
	}

	public void setTextComment(String textComment) {
		this.textComment = textComment;
	}

	public LocalDateTime getDateComment() {
		return dateComment;
	}

	public void setDateComment(LocalDateTime dateComment) {
		this.dateComment = dateComment;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public List<LikeComment> getLikeComment() {
		return likeComment;
	}

	public void setLikeComment(List<LikeComment> likeComment) {
		this.likeComment = likeComment;
	}
	
	
}

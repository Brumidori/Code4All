package com.socialnetwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_like_comments")
public class LikeComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@ManyToOne
	@JsonIgnoreProperties("likeComment")
	private profile profile;
	
	@ManyToOne
	@JsonIgnoreProperties("likeComment")
	private Comment comment;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public profile getUserDetails() {
		return profile;
	}

	public void setUserDetails(profile profile) {
		this.profile = profile;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

		
}

package com.socialnetwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_followers")

public class Followers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_following;
	
	@OneToOne
	private long relationship;
	private long id_user1;
	
	@ManyToOne
	@JoinColumn(name = "userDetails")
	private UserDetails userDetails;

	public long getId_following() {
		return id_following;
	}

	public void setId_following(long id_following) {
		this.id_following = id_following;
	}

	public long getRelationship() {
		return relationship;
	}

	public void setRelationship(long relationship) {
		this.relationship = relationship;
	}

	public long getId_user1() {
		return id_user1;
	}

	public void setId_user1(long id_user1) {
		this.id_user1 = id_user1;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	
	
}


package com.socialnetwork.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	private Profile profile;

}


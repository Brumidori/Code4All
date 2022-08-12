package com.socialnetwork.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_blocked_user")
public class BlockedUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@UpdateTimestamp 
	@NonNull
	private LocalDateTime dateBlock;
	
	@Size(min = 10, max = 255)
	private String blockedDescription;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("blockedUser")
	@JoinColumn(name = "id_user_details", referencedColumnName = "id")
	private UserDetails userDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateBlock() {
		return dateBlock;
	}

	public void setDateBlock(LocalDateTime dateBlock) {
		this.dateBlock = dateBlock;
	}

	public String getBlockedDescription() {
		return blockedDescription;
	}

	public void setBlockedDescription(String blockedDescription) {
		this.blockedDescription = blockedDescription;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

}

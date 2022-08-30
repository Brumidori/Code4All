package com.socialnetwork.model;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	
	@ManyToOne
	@JsonIgnoreProperties("blockedUser")
	private Profile profile;
}

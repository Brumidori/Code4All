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
	private Profile profile;

	@OneToMany(mappedBy = "comment", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("comment")
	private List<LikeComment> likeComment;

	
}

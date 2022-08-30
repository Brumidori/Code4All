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
	private Profile profile;

	@ManyToOne
	@JsonIgnoreProperties("post")
	private Category category;

	@OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("post")
	private List<Comment> comment;

}

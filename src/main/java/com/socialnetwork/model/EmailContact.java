package com.socialnetwork.model;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_email_contact")

public class EmailContact {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@UpdateTimestamp
	@NotNull(message = "A data é obrigatória!")
	private LocalDateTime dateEmail;
	
	@NotNull
	private LocalDateTime deadlineDate;
	
	@NotNull
	@UpdateTimestamp
	private LocalDateTime validationDate;
	
	@ManyToOne
	@JsonIgnoreProperties("emailContact")
	private Profile profile;

	@ManyToOne
	@JsonIgnoreProperties("emailContact")
	private ContactEmail contactEmail;

}
package com.socialnetwork.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_contact_email")

public class ContactEmail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_contact_email;
	
	@NotBlank
	@Size(min = 5, max = 500)
	private String contact_description;

	@OneToMany(mappedBy = "contactEmail", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("contactEmail")
	private List<EmailContact> emailContacts ;


}




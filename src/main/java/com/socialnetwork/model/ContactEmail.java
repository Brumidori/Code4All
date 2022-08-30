package com.socialnetwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_contact_email")

public class ContactEmail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_contact_email;
	
	@NotBlank
	@Size(min = 5, max = 500)
	private String contact_description;
	
	public long getId_contact_email() {
		return id_contact_email;
	}

	public void setId_contact_email(long id_contact_email) {
		this.id_contact_email = id_contact_email;
	}

	public String getContact_description() {
		return contact_description;
	}

	public void setContact_description(String contact_description) {
		this.contact_description = contact_description;
	}

	public EmailContact getEmailContact() {
		return EmailContact;
	}

	public void setEmailContact(EmailContact emailContact) {
		EmailContact = emailContact;
	}

	@OneToOne
	@JoinColumn(name = "email_contact")
	private EmailContact EmailContact;

 
}




package com.socialnetwork.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tb_email_contact")

public class EmailContact {
	
	@Id
	@UpdateTimestamp
	@NotNull(message = "A data é obrigatória!")
	private LocalDateTime date_email;
	
	@NotNull
	private LocalDateTime deadline_date;
	
	@NotNull
	@UpdateTimestamp
	private LocalDateTime validation_date;
	
	private long id_contact_email;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tb_user_details_document;
	
	@OneToOne
	@JoinColumn(name = "contact_email")
	private ContactEmail contactEmail;

	public LocalDateTime getDate_email() {
		return date_email;
	}

	public void setDate_email(LocalDateTime date_email) {
		this.date_email = date_email;
	}

	public LocalDateTime getDeadline_date() {
		return deadline_date;
	}

	public void setDeadline_date(LocalDateTime deadline_date) {
		this.deadline_date = deadline_date;
	}

	public LocalDateTime getValidation_date() {
		return validation_date;
	}

	public void setValidation_date(LocalDateTime validation_date) {
		this.validation_date = validation_date;
	}

	public long getId_contact_email() {
		return id_contact_email;
	}

	public void setId_contact_email(long id_contact_email) {
		this.id_contact_email = id_contact_email;
	}

	public long getTb_user_details_document() {
		return tb_user_details_document;
	}

	public void setTb_user_details_document(long tb_user_details_document) {
		this.tb_user_details_document = tb_user_details_document;
	}

	public ContactEmail getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(ContactEmail contactEmail) {
		this.contactEmail = contactEmail;
	}
	
		
	
		}
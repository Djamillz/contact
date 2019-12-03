package com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
public @Data class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	private String firstname;
	
	private String lastname;
	
	@Temporal(TemporalType.DATE) // .DATE .TIME or .TIMESTAMP
	private Date birthdate;

}

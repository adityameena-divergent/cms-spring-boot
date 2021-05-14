package com.divergentsl.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "doctor")
@Getter
@Setter
@ToString
public class Doctor {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "specialization")
	private String specialization;
	
	@Column(name = "fee")
	private int fee;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	
	
}

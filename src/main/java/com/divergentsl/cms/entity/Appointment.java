package com.divergentsl.cms.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "appointment")
@Getter
@Setter
public class Appointment {

	@Id
	private int id;
	
	private String problem;
	
	private LocalDate date;
	
	
	@ManyToOne(targetEntity = Patient.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@ManyToOne(targetEntity = Doctor.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	
}

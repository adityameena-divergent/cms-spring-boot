package com.divergentsl.cms.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.divergentsl.cms.entity.Patient;
import com.divergentsl.cms.service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientRestController {

	@Autowired
	PatientService patientService;
	
	@GetMapping(path = "/get", consumes = "application/json")
	public ResponseEntity<List<Patient>> findAll() {
		List<Patient> patientList = patientService.findAll();
		return new ResponseEntity<>(patientList, HttpStatus.OK);
	}
	
	@GetMapping(path = "/get/{id}", consumes = "application/json")
	public ResponseEntity<Patient> findById(@PathVariable int id) {
		Patient patient = patientService.find(id);
		if(patient != null) {
			return new ResponseEntity<Patient>(patient, HttpStatus.OK);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "data not found");
		}
	}
	
	@PostMapping(path = "/save")
	public ResponseEntity<HttpStatus> save(@RequestBody Patient patient) {
		patientService.insert(patient.getId(), patient.getName(), patient.getGender(), patient.getAge(), patient.getWeight(), patient.getContactNumber(), patient.getAddress());
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@PutMapping(path = "/save")
	public ResponseEntity<HttpStatus> update(@RequestBody Patient patient) {
		patientService.update(patient.getId(), patient.getName(), patient.getGender(), patient.getAge(), patient.getWeight(), patient.getContactNumber(), patient.getAddress());
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
}

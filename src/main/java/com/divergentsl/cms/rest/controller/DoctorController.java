package com.divergentsl.cms.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.divergentsl.cms.entity.Doctor;
import com.divergentsl.cms.service.DoctorService;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

	@Autowired
	DoctorService doctorService;
	
	@PostMapping("/save")
	public ResponseEntity<HttpStatus> add(@RequestBody Doctor doctor) {
		doctorService.add(doctor);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public Doctor findById(@RequestParam int id) {
		return doctorService.findById(id);
	}
	
	@GetMapping("/get")
	public List<Doctor> findAll() {
		return doctorService.findAll();
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<HttpStatus> remove(@RequestParam int id) {
		if(doctorService.delete(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PutMapping("/save")
	public ResponseEntity<HttpStatus> update(@RequestBody Doctor doctor) {
		if(doctorService.update(doctor)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
}

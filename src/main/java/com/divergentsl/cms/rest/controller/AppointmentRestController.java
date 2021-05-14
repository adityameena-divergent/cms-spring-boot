package com.divergentsl.cms.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.divergentsl.cms.entity.Appointment;
import com.divergentsl.cms.service.AppointmentService;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentRestController {

	@Autowired
	AppointmentService appointmentService;
	
	@PostMapping("/make")
	public ResponseEntity<HttpStatus> makeAppointment(@RequestBody Appointment appointment) {
		appointmentService.makeAppointment(appointment);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/allpatient")
	public List<Appointment> getAllPatient() {
		return appointmentService.getAllPatient();
	}
	
	@GetMapping("/patienthistory/{id}")
	public List<Appointment> getPatientHisotry(@RequestParam int id) {
		return appointmentService.getPatientHistory(id);
	}
	
	@GetMapping("/getappointtodoctor/{id}")
	public List<Appointment> getPatientAppointToDoctor(@RequestParam int id) {
		return appointmentService.getPatientAppointToDoctor(id);
	}
	
	
}

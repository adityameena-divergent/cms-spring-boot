package com.divergentsl.cms.service;

import java.util.List;

import com.divergentsl.cms.entity.Appointment;

public interface AppointmentService {
	
	public void makeAppointment(Appointment appointment);

	public List<Appointment> getAllPatient();
	
	public List<Appointment> getPatientHistory(int id);
	
	public List<Appointment> getPatientAppointToDoctor(int id);
	
}

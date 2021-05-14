package com.divergentsl.cms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergentsl.cms.dao.AppointmentDao;
import com.divergentsl.cms.dao.BaseDAO;
import com.divergentsl.cms.dao.DoctorDao;
import com.divergentsl.cms.entity.Appointment;
import com.divergentsl.cms.entity.Patient;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentDao appointmentDao;
	
	@Autowired
	DoctorDao doctorDao;
	
	@Autowired
	BaseDAO<Patient> patientDao;
	
	@Override
	public void makeAppointment(Appointment appointment) {
		appointment.setDoctor(doctorDao.findById(appointment.getDoctorId()).get());
		appointment.setPatient(patientDao.find(appointment.getPatientId()));
		
		appointmentDao.save(appointment);
	}
	
	@Override
	public List<Appointment> getAllPatient() {	
		return appointmentDao.findAll();
	}

	@Override
	public List<Appointment> getPatientHistory(int id) {
		return appointmentDao.findAll().stream().filter(p -> p.getPatient().getId() == id).collect(Collectors.toList());
	}

	@Override
	public List<Appointment> getPatientAppointToDoctor(int id) {
		return appointmentDao.findAll().stream().filter(d -> d.getDoctor().getId() == id).collect(Collectors.toList());
	}

}

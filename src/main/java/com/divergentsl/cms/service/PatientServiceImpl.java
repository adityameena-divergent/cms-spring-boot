package com.divergentsl.cms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergentsl.cms.dao.BaseDAO;
import com.divergentsl.cms.dao.PatientDaoImpl;
import com.divergentsl.cms.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	BaseDAO<Patient> patientDao = new PatientDaoImpl();
	
	@Transactional
	public void insert(int patientId, String patientName, String gender, int age, int weight, int contactNumber, String address) {
		
		Patient patient = new Patient();
		patient.setId(patientId);
		patient.setName(patientName);
		patient.setGender(gender);
		patient.setAge(age);
		patient.setWeight(weight);
		patient.setContactNumber(contactNumber);
		patient.setAddress(address);
		
		patientDao.insert(patient);
		
	}

	@Transactional
	public List<Patient> findAll() {
		
		return patientDao.findAll();
	}

	@Transactional
	public Patient find(int patientId) {
		return patientDao.find(patientId);
	}

	@Transactional
	public void remove(int patientId) {
		patientDao.remove(patientId);
	}

	@Transactional
	public void update(int patientId, String patientName, String gender, int age, int weight, int contactNumber,
			String address) {
		Patient patient = new Patient();
		patient.setId(patientId);
		patient.setName(patientName);
		patient.setGender(gender);
		patient.setAge(age);
		patient.setWeight(weight);
		patient.setContactNumber(contactNumber);
		patient.setAddress(address);
		
		patientDao.update(patient);
	}	
	
}

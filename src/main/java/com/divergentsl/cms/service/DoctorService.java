package com.divergentsl.cms.service;

import java.util.List;

import com.divergentsl.cms.entity.Doctor;

public interface DoctorService {

	public void add(Doctor doctor);
	
	public Doctor findById(int id);
	
	public List<Doctor> findAll();
	
	public boolean delete(int id);
	
	public boolean update(Doctor doctor);
	
}

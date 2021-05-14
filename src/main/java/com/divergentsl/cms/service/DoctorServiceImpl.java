package com.divergentsl.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergentsl.cms.dao.DoctorDao;
import com.divergentsl.cms.entity.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorDao doctorDao;
	
	@Override
	public void add(Doctor doctor) {
		doctorDao.save(doctor);
	}

	@Override
	public Doctor findById(int id) {
		return doctorDao.findById(id).get();
	}

	@Override
	public List<Doctor> findAll() {
		return doctorDao.findAll();
	}

	@Override
	public boolean delete(int id) {
		Doctor doctor = doctorDao.findById(id).get();
		if(doctor != null) {
			doctorDao.delete(doctor);
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean update(Doctor doctor) {
		if(doctorDao.findById(doctor.getId()).get() != null) {
			doctorDao.save(doctor);
			return true;
		}
		else {
			return false;
		}
			
	}

}

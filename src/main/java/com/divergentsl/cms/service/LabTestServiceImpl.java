package com.divergentsl.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergentsl.cms.dao.LabTestDao;
import com.divergentsl.cms.entity.LabTest;

@Service
public class LabTestServiceImpl implements LabTestService {

	@Autowired
	LabTestDao labTestDao;
	
	@Override
	public void save(LabTest labTest) {
		labTestDao.save(labTest);
	}

	@Override
	public LabTest findById(int id) {
		return labTestDao.findById(id).get();
	}

	@Override
	public List<LabTest> findAll() {
		return labTestDao.findAll();
	}

	@Override
	public boolean remove(int id) {
		
		LabTest labTest = labTestDao.findById(id).get();
		if(labTest != null) {
			labTestDao.delete(labTest);
			return true;
		} 
		return false;
	}

	@Override
	public boolean update(LabTest labTest) {
		LabTest test = labTestDao.findById(labTest.getTestId()).get();
		if(test != null) {
			labTestDao.delete(labTest);
			return true;
		}
		return false;
	}

}

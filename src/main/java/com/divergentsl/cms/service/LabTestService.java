package com.divergentsl.cms.service;

import java.util.List;

import com.divergentsl.cms.entity.LabTest;

public interface LabTestService {

	public void save(LabTest labTest);
	
	public LabTest findById(int id);
	
	public List<LabTest> findAll();
	
	public boolean remove(int id);
	
	public boolean update(LabTest labTest);
	
}

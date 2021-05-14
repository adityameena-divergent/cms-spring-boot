package com.divergentsl.cms.service;

import java.util.List;

import com.divergentsl.cms.entity.Drug;

public interface DrugService {

public void save(Drug drug);
	
	public Drug findById(int id);
	
	public List<Drug> findAll();
	
	public boolean remove(int id);
	
	public boolean update(Drug drug);
	
	
}

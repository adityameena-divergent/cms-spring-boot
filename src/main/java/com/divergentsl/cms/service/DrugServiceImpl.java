package com.divergentsl.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergentsl.cms.dao.DrugDao;
import com.divergentsl.cms.entity.Drug;

@Service
public class DrugServiceImpl implements DrugService {

	@Autowired
	DrugDao drugDao;
	
	@Override
	public void save(Drug drug) {
		drugDao.save(drug);
	}

	@Override
	public Drug findById(int id) {
		return drugDao.findById(id).get();
	}

	@Override
	public List<Drug> findAll() {
		return drugDao.findAll();
	}

	@Override
	public boolean remove(int id) {
		
		Drug drug = drugDao.findById(id).get();
		if(drug != null) {
			drugDao.delete(drug);
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Drug drug) {
		
		Drug d = drugDao.findById(drug.getId()).get();
		if(d != null) {
			drugDao.save(drug);
			return true;
		}
		return false;
	}

}

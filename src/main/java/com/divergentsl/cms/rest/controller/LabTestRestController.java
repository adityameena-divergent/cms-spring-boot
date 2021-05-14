package com.divergentsl.cms.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.divergentsl.cms.entity.LabTest;
import com.divergentsl.cms.service.LabTestService;

@RestController
@RequestMapping("/labtest")
public class LabTestRestController {

	@Autowired
	LabTestService labTestService;
	
	@PostMapping("/save")
	public void save(@RequestBody LabTest labTest) {
		labTestService.save(labTest);
	}
	
	@GetMapping("/get/{id}")
	public LabTest findById(@RequestParam int id) {
		return labTestService.findById(id);
	}
	
	
	@GetMapping("/get")
	public List<LabTest> findAll() {
		return labTestService.findAll();
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<HttpStatus> remove(@RequestParam int id) {
		if(labTestService.remove(id)) {
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} else {
			return new ResponseEntity<HttpStatus>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PutMapping("/save")
	public ResponseEntity<HttpStatus> update(@RequestBody LabTest labTest) {
		if(labTestService.update(labTest)) {
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} else {
			return new ResponseEntity<HttpStatus>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
}

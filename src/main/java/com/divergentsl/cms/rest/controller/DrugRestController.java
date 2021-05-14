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

import com.divergentsl.cms.entity.Drug;
import com.divergentsl.cms.service.DrugService;

@RestController
@RequestMapping("/drug")
public class DrugRestController {

	@Autowired
	DrugService drugService;
	
	
	@PostMapping("/save")
	public void save(@RequestBody Drug drug) {
		drugService.save(drug);
	}
	
	@GetMapping("/get/{id}")
	public Drug findById(@RequestParam int id) {
		return drugService.findById(id);
	}
	
	@GetMapping("/get")
	public List<Drug> findAll() {
		return drugService.findAll();
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<HttpStatus> remove(@RequestParam int id) {
		if(drugService.remove(id)) {
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} else {
			return new ResponseEntity<HttpStatus>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PutMapping("/save")
	public ResponseEntity<HttpStatus> remove(@RequestBody Drug drug) {
		if(drugService.update(drug)) {
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} else {
			return new ResponseEntity<HttpStatus>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	
	
}

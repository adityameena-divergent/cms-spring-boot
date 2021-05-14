package com.divergentsl.cms.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.divergentsl.cms.entity.Admin;
import com.divergentsl.cms.service.AdminService;


@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminRestController {

	@Autowired
    private AdminService adminService;

    @RequestMapping(path = "/login", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<HttpStatus> login(@RequestBody Admin admin) {
		
		if (adminService.login(admin.getUsername(), admin.getPassword())) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	} 

}

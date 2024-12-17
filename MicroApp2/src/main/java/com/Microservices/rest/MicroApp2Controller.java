package com.Microservices.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Microservices.service.MicroApp2Service;

@RestController
public class MicroApp2Controller {
	
	@Autowired
	private MicroApp2Service service;

	@GetMapping("/details")
	public ResponseEntity<String> getTheInfo(){
		
		String info = service.getTheInfo();
		return new ResponseEntity<String>(info,HttpStatus.OK);
	}
	
}

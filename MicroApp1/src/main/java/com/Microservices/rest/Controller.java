package com.Microservices.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/info")
	public ResponseEntity<String> getTheInfo(){
		
		String info = "Learning Microsevices";
		return new ResponseEntity<String>(info,HttpStatus.OK);
	}
	
}

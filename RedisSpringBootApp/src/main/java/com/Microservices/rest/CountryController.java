package com.Microservices.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Microservices.model.Country;
import com.Microservices.service.CountryService;

@RestController
public class CountryController {

	@Autowired
	private CountryService service;
	
	@PostMapping
	public ResponseEntity<String> addCountry(@RequestBody Country country){
		
		String res = service.addCountry(country);
		
		return new ResponseEntity<>(res,HttpStatus.CREATED);
	}

	// cannot access because cannot de-serializable
//	@GetMapping
//	public ResponseEntity<Collection<Object>> getCountries(){
//		
//		return new ResponseEntity<>(service.getAllCountries(),HttpStatus.OK);
//	}
	
}

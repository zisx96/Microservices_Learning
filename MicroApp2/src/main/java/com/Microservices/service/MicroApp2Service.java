package com.Microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MicroApp2Service {
	
	@Autowired
	private IFeignClient client;
	
	public String getTheInfo() {
		
//		RestTemplate restTemplate = new RestTemplate();
//		
//		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8482/info", 
//				String.class);
//		
//		return response.getBody() + "coming from another api.";
		
		ResponseEntity<String> response = client.getTheInfo();	
		
		return response.getBody() + "coming from another api.";
	}
	
}

package com.Microservices.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="MICROAPP1")
public interface IFeignClient {
	
	@GetMapping("/info")
	public ResponseEntity<String> getTheInfo();
	
}

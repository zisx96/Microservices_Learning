package com.Microservices.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.Microservices.model.Country;

@Service
public class CountryService {

	private HashOperations<String, Object, Object> opsForHash=null;
	
	public CountryService(RedisTemplate<String, Country> redis){
		
		opsForHash = redis.opsForHash();
		
	}
	
	public String addCountry(Country country) {
		
		opsForHash.put("COUNTRIES", country.getNo(), country);
		return "country data added into redis server";
		
	}
	
//	public Collection<Object> getAllCountries(){
//		
//		Map<Object, Object> entries = opsForHash.entries("COUNTRIES");
//		Collection<Object> countries = entries.values();
//		return countries;
//	}
	
}

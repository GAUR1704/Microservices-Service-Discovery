package com.prowings.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prowings.model.Climate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class InvokerService {
	
	@Autowired
	RestTemplate restTemplate;
	
	String url = "http://localhost:8084/prowings/climates/";

	@CircuitBreaker(name = "climateCircuitBreaker", fallbackMethod = "climateFallback")
	public String getClimate(String city) {
		
		log.info("service method started!!!");
		
		Climate response = restTemplate.getForObject(url+city, Climate.class);
		
		log.info(">>>>>>>>>Response from climate is : {}",response);
		
		return "successfully fetched climate details for city : "+city;
	}

	
	public String climateFallback(String city, Throwable t)
	{
		log.info("in fallback method of climate!!");
		
		return "Climate service is temporarily unavailable!!!";

	}
	
	

}

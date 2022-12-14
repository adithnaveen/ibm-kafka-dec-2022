package com.ibm.kafka.works.springbootworks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.kafka.works.springbootworks.service.KafkaService;

@RestController
public class KafkaController {

	@Autowired
	private KafkaService service; 
	
	// http://localhost:8080/producer/hello
	@GetMapping(value="/producer/{message}")
	public String sendMessage( @PathVariable("message") String message) {
		  service.sendMessage(message);
		  return "Delivered Message " + message;
	}
}

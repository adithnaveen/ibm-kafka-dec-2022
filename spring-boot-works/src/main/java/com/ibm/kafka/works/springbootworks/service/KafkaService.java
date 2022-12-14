package com.ibm.kafka.works.springbootworks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
	// the injection of the object is taken care by spring boot 
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate ;  
	
	private String kafkaTopic = "first-topic"; 
	
	// methods 
	
	public void sendMessage(String message) {
		kafkaTemplate.send(kafkaTopic, message);
	}
}

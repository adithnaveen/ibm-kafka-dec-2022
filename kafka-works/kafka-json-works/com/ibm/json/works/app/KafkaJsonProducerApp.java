package com.ibm.json.works.app;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.json.works.beans.Employee;
import com.ibm.json.works.dao.EmployeeDAO;
import com.ibm.json.works.jsondata.KafkaJsonSerializer;

public class KafkaJsonProducerApp {
	
	private static final Logger log = LoggerFactory.getLogger(KafkaJsonProducerApp.class.getName()); 
	public static void main(String[] args) {
		final String HOST = "localhost"; 
		final String PORT = "9092"; 
		
		Properties prop = new Properties(); 
		prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, HOST + ":" + PORT);
		prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		EmployeeDAO dao = new EmployeeDAO(); 
		Employee emp = dao.getEmployee(100);
		
		ProducerRecord<String, Employee> producerRecord = new ProducerRecord<String, Employee>("first-topic", emp);
		
		
		KafkaProducer<String, Employee> kafkaProducer = 
				new KafkaProducer<>(prop, new StringSerializer(), new KafkaJsonSerializer()); 
		 
		
		
		kafkaProducer.send(producerRecord, (metadata, exception) -> {
			if (exception == null) {
				log.info("----------------------------------------------");
				log.info("Message Sent Successfully");
				log.info("Topic " + metadata.topic() + "\tPartition " + metadata.partition() + "\nTime Stamp "
						+ metadata.timestamp() + "\tOffSet " + metadata.offset());

			} else {
				log.error("Sorry! Exception while posting message {}", exception);
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		kafkaProducer.flush();
		kafkaProducer.close();
	}
}

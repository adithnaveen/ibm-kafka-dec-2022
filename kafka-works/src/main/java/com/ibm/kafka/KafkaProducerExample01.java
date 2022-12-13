package com.ibm.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaProducerExample01 {
	
	private static final Logger log = LoggerFactory.getLogger(KafkaProducerExample01.class.getName());
	
	public static void main(String[] args) {
		final String HOST = "localhost"; 
		final String PORT = "9092"; 
		
		Properties prop = new Properties(); 
		// prop.put("bootstrap.servers", HOST + ":" + PORT);
		prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, HOST + ":" + PORT);
		prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		KafkaProducer<String, String> producer = new KafkaProducer<>(prop);
		
		ProducerRecord<String, String> producerRecord = 
				new ProducerRecord<String, String>("ibm-java-topic", "Hello World From Java1");
		
		producer.send(producerRecord, new Callback() {
			
			@Override
			public void onCompletion(RecordMetadata metadata, Exception exception) {
				if(exception == null) {
					log.info("----------------------------------------------");
					log.info("Message Sent Successfully");
					log.info("Topic " + metadata.topic() + 
								"\nPartition " + metadata.partition() + 
								"\nTime Stamp " + metadata.timestamp() +
								"\nOffSet " + metadata.offset()); 
					
				}else {
					log.error("Sorry! Exception while posting message {}", exception);
				}
			}
		});
		
		producer.flush(); 
		producer.close();
		
		
		
		
	}
}


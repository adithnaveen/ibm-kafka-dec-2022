package com.ibm.kafka;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaConsumerExample02 {
	
	private static final Logger log = LoggerFactory.getLogger(KafkaConsumerExample02.class.getName()); 
	
	public static void main(String[] args) {
		final String HOST = "localhost"; 
		final String PORT = "9092"; 
		
		Properties prop = new Properties(); 
		prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, HOST + ":" + PORT);
		prop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		prop.put(ConsumerConfig.GROUP_ID_CONFIG, "my-java-group");
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(prop);
		consumer.subscribe(Arrays.asList("ibm-java-topic"));
		
		while(true) {
			log.info("---- Polling -----");
			// ctrl  2 + l (short cut to create a record)  
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000)); 
			
			for(ConsumerRecord<String, String> record : records) {
				log.info("\n Key : " + record.key() + 
						"\nValue : " + record.value() +
						"\nPartition : " + record.partition()  +
						"\nOffset " + record.offset());
			}
		}
		
		
	}
}

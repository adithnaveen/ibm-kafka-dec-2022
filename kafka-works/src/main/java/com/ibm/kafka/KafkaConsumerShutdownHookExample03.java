package com.ibm.kafka;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaConsumerShutdownHookExample03 {
	
	private static final Logger log = LoggerFactory.getLogger(KafkaConsumerShutdownHookExample03.class.getName()); 
	
	public static void main(String[] args) {
		final String HOST = "localhost"; 
		final String PORT = "9092"; 
		
		Properties prop = new Properties(); 
		prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, HOST + ":" + PORT);
		prop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		prop.put(ConsumerConfig.GROUP_ID_CONFIG, "my-java-group");
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(prop);
		
		
		
		System.out.println("Running " + Thread.currentThread().getName());
		Thread mainThread = Thread.currentThread(); 
		
		// when ever you disturn the main thread it should short other thread 
		// running (in our case its kafka) 
		Runtime.getRuntime().addShutdownHook(new Thread() {

			@Override
			public void run() {
				log.info("Detected Shudown Lets Exit");
				consumer.wakeup();
				
				try {
					mainThread.join();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
		// this is the main thread 
		try {
		consumer.subscribe(Arrays.asList("fourth-topic"));
		while(true) {
			// ctrl  2 + l (short cut to create a record)  
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000)); 
			
			for(ConsumerRecord<String, String> record : records) {
				log.info("\n Key : " + record.key() + 
						"\tValue : " + record.value() +
						"\tPartition : " + record.partition()  +
						"\tOffset " + record.offset());
			}
		}
		}catch(WakeupException we) {
			// this occurs when the exception is thrown or wakeup call happens  
			log.error("Wake up Exception Called " + we.getMessage());
		}catch(Exception e) {
			log.error("Exception in Main " + e.getMessage());
		}finally {
			consumer.close(); 
			log.info("Closing the program");
		}
		
	}
}

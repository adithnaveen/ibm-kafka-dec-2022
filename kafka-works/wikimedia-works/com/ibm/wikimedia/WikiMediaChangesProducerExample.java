package com.ibm.wikimedia;

import java.net.URI;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

public class WikiMediaChangesProducerExample {
	public static void main(String[] args) throws InterruptedException {
		final String HOST = "localhost"; 
		final String PORT = "9092"; 
		final String URL ="https://stream.wikimedia.org/v2/stream/recentchange";
		final String TOPIC = "wikimedia.recentchange"; 
		
		Properties prop = new Properties(); 

		prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, HOST + ":" + PORT);
		prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		KafkaProducer<String, String> producer = new KafkaProducer<>(prop);
		EventHandler eventHandler = new WikiMediaEventHandler(producer, TOPIC); 
		
		EventSource.Builder  builder = new EventSource.Builder(eventHandler, URI.create(URL)); 
		EventSource eventSource = builder.build();
		
		eventSource.start(); 
		
		TimeUnit.MINUTES.sleep(10);
	}
}

package com.ibm.wikimedia;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

public class WikiMediaEventHandler implements EventHandler {

	private static final Logger log = LoggerFactory.getLogger(WikiMediaEventHandler.class.getName());
	
	private KafkaProducer<String, String> producer; 
	private String topic; 
	
	public WikiMediaEventHandler(KafkaProducer<String, String> producer, String topic) {
		super();
		this.producer = producer;
		this.topic = topic;
	}

	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClosed() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {

		log.info(messageEvent.getData());
		producer.send(new ProducerRecord<String, String>(topic, messageEvent.getData()));
		
	}

	@Override
	public void onComment(String comment) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Throwable t) {
		log.error("Error While streaming  : " + t);
	}

}

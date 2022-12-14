package com.ibm.json.works.jsondata;

import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class KafkaJsonSerializer implements Serializer {

	private static final Logger log = LoggerFactory.getLogger(KafkaJsonSerializer.class.getName());

	@Override
	public byte[] serialize(String topic, Object data) {
		byte[] retVal = null;

		try {
			ObjectMapper om = new ObjectMapper();
			retVal = om.writeValueAsBytes(data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return retVal;
	}

}

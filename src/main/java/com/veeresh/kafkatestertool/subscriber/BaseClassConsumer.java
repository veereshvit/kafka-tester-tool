package com.veeresh.kafkatestertool.subscriber;

import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.veeresh.kafkatestertool.configuration.ConsumerConfiguration;
import com.veeresh.kafkatestertool.configuration.JsonValidationConfig;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class BaseClassConsumer {
    String matched=null;

    @Autowired
    ConsumerConfiguration consumerConfiguration;

@Autowired
    JsonValidationConfig jsonValidationConfig;

    public String  getBaseClassRecord(){

try {
    final Consumer consumer = new KafkaConsumer(consumerConfiguration.consumerFactory());
    consumer.subscribe(Collections.singletonList("BaseTopic"));
    final ConsumerRecords<Long, String> consumerRecords =
            consumer.poll(100);
    consumerRecords.forEach(record -> {
        System.out.printf("Consumer Record:(%d, %s, %d, %d)\n",
                record.key(), record.value(),
                record.partition(), record.offset());

  if(    jsonValidationConfig.readJsonFile().equalsIgnoreCase(record.value()))
  {
      matched="200";
  }else{
      matched="failed";
  }


    });


}catch (Exception e){
    e.printStackTrace();
}

return matched;
    }


}

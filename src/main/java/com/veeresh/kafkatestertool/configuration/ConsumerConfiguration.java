package com.veeresh.kafkatestertool.configuration;

import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConsumerConfiguration {


    @Value("${spring.kafka.brokers}")
    private String bootstrapAddress;

    @Value("{spring.kafka.groupId}")
    private String groupId;



    @Bean
    public Map<String, String> consumerFactory() {
        Map<String, String> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        props.put(
                ConsumerConfig.GROUP_ID_CONFIG,
                groupId);
        props.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,org.apache.kafka.common.serialization.StringDeserializer.class.getName()
        );
        props.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                org.apache.kafka.common.serialization.StringDeserializer.class.getName());
        return props;
    }



}

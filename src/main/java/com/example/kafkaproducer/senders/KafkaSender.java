package com.example.kafkaproducer.senders;

import com.example.kafkaproducer.configurations.KafkaConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSender implements Sender{

    @Autowired
    KafkaTemplate<Integer,String> kafkaTemplate;

    @Override
    public void send(String message) {
        kafkaTemplate.send(KafkaConfiguration.TOPIC, message);
    }
}

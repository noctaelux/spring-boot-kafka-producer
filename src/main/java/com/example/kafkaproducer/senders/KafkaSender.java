package com.example.kafkaproducer.senders;

import com.example.kafkaproducer.configurations.KafkaConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaSender implements Sender{

    private final KafkaTemplate<Integer,String> kafkaTemplate;

    @Override
    public void send(String message) {
        kafkaTemplate.send(KafkaConfiguration.KAFKA_TOPIC, message);
    }
}

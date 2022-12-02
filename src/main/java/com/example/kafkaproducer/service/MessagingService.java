package com.example.kafkaproducer.service;

import javax.management.AttributeNotFoundException;

public interface MessagingService {

    void sendMessage(Object mensaje) throws AttributeNotFoundException;

}

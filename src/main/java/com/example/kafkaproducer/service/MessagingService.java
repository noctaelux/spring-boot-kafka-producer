package com.example.kafkaproducer.service;

import javax.management.AttributeNotFoundException;

public interface MessagingService {

    void sendJsonMessage(Object mensaje) throws AttributeNotFoundException;

}

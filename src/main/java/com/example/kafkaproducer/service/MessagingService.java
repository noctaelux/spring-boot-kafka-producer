package com.example.kafkaproducer.service;

import javax.management.AttributeNotFoundException;

public interface MessagingService {

    public void sendMessage(String mensaje) throws AttributeNotFoundException;

}

package com.example.kafkaproducer.service;

import com.example.kafkaproducer.senders.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.AttributeNotFoundException;

@Service
public class MessagingServiceImpl implements MessagingService{

    @Autowired
    Sender sender;

    @Override
    public void sendMessage(String mensaje) throws AttributeNotFoundException {
        if (mensaje.isEmpty()){
            throw new AttributeNotFoundException("Attribute message cannot be null or empty string.");
        }
        sender.send(mensaje);
    }
}

package com.example.kafkaproducer.service;

import com.example.kafkaproducer.senders.Sender;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.management.AttributeNotFoundException;

@Service
@RequiredArgsConstructor
public class MessagingServiceImpl implements MessagingService{

    private final Logger LOG = LoggerFactory.getLogger(MessagingServiceImpl.class);

    private final Sender sender;

    private final MessageMarshalling messageMarshalling;

    @Override
    public void sendJsonMessage(Object mensaje) throws AttributeNotFoundException {

        String marshalledMessage;
        try {
            marshalledMessage = messageMarshalling.toJson(mensaje);
            if (marshalledMessage.isEmpty()){
                throw new AttributeNotFoundException("Attribute message cannot be null or empty string.");
            }
            LOG.info("Sending to queue ---> : "+marshalledMessage);
            sender.send(marshalledMessage);
        } catch (JsonProcessingException e) {
            LOG.error(e.getMessage());
        }
    }
}

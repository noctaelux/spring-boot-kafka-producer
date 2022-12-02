package com.example.kafkaproducer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class MessageMarshallingImpl implements MessageMarshalling{

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String toJson(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

}

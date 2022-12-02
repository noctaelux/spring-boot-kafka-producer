package com.example.kafkaproducer.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface MessageMarshalling {

    String toJson(Object object) throws JsonProcessingException;

}

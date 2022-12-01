package com.example.kafkaproducer.runners;

import com.example.kafkaproducer.service.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private MessagingService messagingService;

    @Override
    public void run(String... args) throws Exception {
        messagingService.sendMessage("Hola Mundo desde Spring boot!");
    }
}

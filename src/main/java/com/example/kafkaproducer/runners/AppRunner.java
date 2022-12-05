package com.example.kafkaproducer.runners;

import com.example.kafkaproducer.models.Direccion;
import com.example.kafkaproducer.models.Usuario;
import com.example.kafkaproducer.service.MessagingService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class AppRunner implements CommandLineRunner {

    private final MessagingService messagingService;

    @Override
    public void run(String... args) throws Exception {

        Usuario usuario = Usuario.builder()
                .nombre("Oscar")
                .apellidos("Calzada")
                .fechaNacimiento(new Date())
                .direccion(Direccion.builder()
                        .colonia("San Nicolás")
                        .calle("Juán de Dios")
                        .numero(22)
                        .build())
                .build();

        messagingService.sendMessage(usuario);
    }
}

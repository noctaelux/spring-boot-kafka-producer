package com.example.kafkaproducer.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Direccion {

    private String colonia;
    private String calle;
    private Integer numero;

}

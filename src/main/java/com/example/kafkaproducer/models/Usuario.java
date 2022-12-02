package com.example.kafkaproducer.models;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Usuario {

    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;

}

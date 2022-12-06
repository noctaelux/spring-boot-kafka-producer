package com.example.kafkaproducer.models;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class Usuario {

    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private List<String> observaciones;
    private Direccion direccion;

}

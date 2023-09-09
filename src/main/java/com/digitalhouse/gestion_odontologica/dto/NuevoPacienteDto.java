package com.digitalhouse.gestion_odontologica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class NuevoPacienteDto {
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso; //Todo check type
    private DomicilioDto domicilio;
}
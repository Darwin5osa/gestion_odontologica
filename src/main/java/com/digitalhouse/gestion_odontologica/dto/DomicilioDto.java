package com.digitalhouse.gestion_odontologica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DomicilioDto {
    private Integer numPuerta;
    private String calle;
    private String ciudad;
    private String departamento;
    private String pais;
}
package com.digitalhouse.gestion_odontologica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NuevoOdontologoDto {
    private int matricula;
    private String nombre;
    private String apellido;
}
package com.digitalhouse.gestion_odontologica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OdontologoResultadoDto {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer matricula;
}

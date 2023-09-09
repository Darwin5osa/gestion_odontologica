package com.digitalhouse.gestion_odontologica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ActualizarTurnoDto {
    private Date fecha;
    private Long pacienteId;
    private Long odontologoId;
}
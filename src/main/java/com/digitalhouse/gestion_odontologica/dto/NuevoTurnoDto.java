package com.digitalhouse.gestion_odontologica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.NonNull;

import java.util.Date;

@Getter
@AllArgsConstructor
public class NuevoTurnoDto {
    private Date fecha;
    @NonNull
    private Long pacienteId;
    @NonNull
    private Long odontologoId;
}
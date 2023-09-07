package com.digitalhouse.gestion_odontologica.dto;

import com.digitalhouse.gestion_odontologica.entity.Odontologo;
import com.digitalhouse.gestion_odontologica.entity.Paciente;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
@Getter
@AllArgsConstructor
public class NuevoTurnoDto {

    private Date fecha;
    private Paciente paciente;
    private Odontologo odontologo;
}

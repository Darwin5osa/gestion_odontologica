package com.digitalhouse.gestion_odontologica.util;

import com.digitalhouse.gestion_odontologica.dto.NuevoTurnoDto;
import com.digitalhouse.gestion_odontologica.entity.Odontologo;
import com.digitalhouse.gestion_odontologica.entity.Paciente;
import com.digitalhouse.gestion_odontologica.entity.Turno;

public class Mapper {
    public static Turno map(NuevoTurnoDto dto) {
        Turno turno = new Turno();
        Paciente paciente = new Paciente();
        Odontologo odontologo = new Odontologo();

        paciente.setId(dto.getPacienteId());
        odontologo.setId(dto.getOdontologoId());

        turno.setFecha(dto.getFecha());
        turno.setOdontologo(odontologo);
        turno.setPaciente(paciente);

        return turno;
    }
}

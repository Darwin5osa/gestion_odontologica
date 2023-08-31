package com.digitalhouse.gestion_odontologica.util;

import com.digitalhouse.gestion_odontologica.dto.InputPacienteDto;
import com.digitalhouse.gestion_odontologica.entity.Domicilio;
import com.digitalhouse.gestion_odontologica.entity.Paciente;

public class Mapper {
    public static Paciente map(Long id, InputPacienteDto dto) {
        Paciente paciente = new Paciente();
        Domicilio domicilio = new Domicilio();

        paciente.setApellido(dto.getApellido());
        paciente.setDni(dto.getDni());
        paciente.setNombre(dto.getNombre());
        paciente.setDomicilio(domicilio);
        paciente.setId(id);

        domicilio.setNumPuerta(dto.getDomicilio().getNumPuerta());
        domicilio.setCalle(dto.getDomicilio().getCalle());
        domicilio.setCiudad(dto.getDomicilio().getCiudad());
        domicilio.setDepartamento(dto.getDomicilio().getDepartamento());
        domicilio.setPais(dto.getDomicilio().getPais());

        return paciente;
    }
}

package com.digitalhouse.gestion_odontologica.controller;


import com.digitalhouse.gestion_odontologica.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turno")
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TurnoController {
    private final ITurnoService turnoService;
    private final ObjectMapper mapper;

    // TODO: se tiene que poder permitir asignar
    //  a un paciente un turno con un odontólogo
    //  a una determinada fecha y hora.
    // crear
    // asignar odontologo
    // asignar pacientes
    // reagendar fecha y hora
    // eliminar
    // listar
}

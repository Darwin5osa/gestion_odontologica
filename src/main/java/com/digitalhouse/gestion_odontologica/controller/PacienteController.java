package com.digitalhouse.gestion_odontologica.controller;

import com.digitalhouse.gestion_odontologica.Service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    private final IPacienteService odontologoService;

    @Autowired
    public PacienteController(IPacienteService odontologoService) {
        this.odontologoService = odontologoService;
    }
}

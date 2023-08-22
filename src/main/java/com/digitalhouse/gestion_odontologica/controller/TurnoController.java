package com.digitalhouse.gestion_odontologica.controller;


import com.digitalhouse.gestion_odontologica.Service.ITurnoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TurnoController {
    private final ITurnoService turnoService;

    public TurnoController(ITurnoService turnoService) {
        this.turnoService = turnoService;
    }
}

package com.digitalhouse.gestion_odontologica.controller;

import com.digitalhouse.gestion_odontologica.Service.IOdontologoService;
import com.digitalhouse.gestion_odontologica.dto.CrearOdontologoDto;
import com.digitalhouse.gestion_odontologica.model.Odontologo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologo")
@Slf4j
public class OdontologoController {
    private final IOdontologoService odontologoService;
    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping()
    public List<Odontologo> getAllOdontologo() {
        try {
            return odontologoService.listarTodos();
        } catch (Exception exception) {
            log.error("Se produjo un error al intentar listar todos los odontologos", exception);
            return null;
        }
    }

    @PostMapping()
    public void guardarOdontologo(@RequestBody CrearOdontologoDto request) {
        log.debug("Se recibio: " + request + " para guardar");

        try {
            odontologoService.guardar(mapper.convertValue(request, Odontologo.class));
        } catch (Exception exception) {
            log.error("Se produjo un error al intentar guardar el odontologo", exception);
        }
    }
}
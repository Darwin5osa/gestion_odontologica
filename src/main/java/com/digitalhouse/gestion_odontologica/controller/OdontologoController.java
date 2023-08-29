package com.digitalhouse.gestion_odontologica.controller;

import com.digitalhouse.gestion_odontologica.Service.IOdontologoService;
import com.digitalhouse.gestion_odontologica.dto.OdontologoDto;
import com.digitalhouse.gestion_odontologica.entity.Odontologo;
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
    public List<OdontologoDto> getAllOdontologo() {
        try {
            return odontologoService.listarTodos()
                    .stream()
                    .map(odontologo -> mapper.convertValue(odontologo, OdontologoDto.class))
                    .toList();
        } catch (Exception exception) {
            log.error("Se produjo un error al intentar listar todos los odontologos", exception);
            return null;
        }
    }

    @PostMapping()
    public void guardarOdontologo(@RequestBody OdontologoDto odontologoDto) {
        log.debug("Se recibio: " + odontologoDto + " para guardar");

        try {
            odontologoService.guardar(mapper.convertValue(odontologoDto, Odontologo.class));
        } catch (Exception exception) {
            log.error("Se produjo un error al intentar guardar el odontologo", exception);
        }
    }
}
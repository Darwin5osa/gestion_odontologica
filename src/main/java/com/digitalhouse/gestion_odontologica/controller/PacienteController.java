package com.digitalhouse.gestion_odontologica.controller;

import com.digitalhouse.gestion_odontologica.Service.IPacienteService;
import com.digitalhouse.gestion_odontologica.dto.OdontologoDto;
import com.digitalhouse.gestion_odontologica.dto.InputPacienteDto;
import com.digitalhouse.gestion_odontologica.dto.OutputPacienteDto;
import com.digitalhouse.gestion_odontologica.entity.Paciente;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PacienteController {
    private final IPacienteService pacienteService;
    private final ObjectMapper mapper;

    @GetMapping()
    public ResponseEntity<List<OutputPacienteDto>> getAll() {
        try {
            return ResponseEntity.ok(pacienteService.listarTodos()
                    .stream()
                    .map(paciente -> mapper.convertValue(paciente, OutputPacienteDto.class))
                    .toList());
        } catch (Exception exception) {
            log.error("Se produjo un error al intentar listar todos los pacientes", exception);
            return ResponseEntity.;
        }
    }

    @PostMapping()
    public void guardar(@RequestBody InputPacienteDto inputPacienteDto) {
        log.debug("Se recibio: " + inputPacienteDto + " para guardar");

        try {
            pacienteService.guardar(mapper.convertValue(inputPacienteDto, Paciente.class));

        } catch (Exception exception) {
            log.error("Se produjo un error al intentar guardar el paciente", exception);
        }
    }

    @PutMapping()
    public void actualizar(@RequestBody InputPacienteDto inputPacienteDto) {
        log.debug("Se recibio: " + inputPacienteDto + " para guardar");

        try {
            pacienteService.actualizar(mapper.convertValue(inputPacienteDto, Paciente.class));

        } catch (Exception exception) {
            log.error("Se produjo un error al intentar guardar el paciente", exception);
        }
    }
}

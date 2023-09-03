package com.digitalhouse.gestion_odontologica.controller;

import com.digitalhouse.gestion_odontologica.service.IPacienteService;
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
            return ResponseEntity.internalServerError().build();
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

    @PutMapping("/{id}")
    public void actualizar(@RequestBody InputPacienteDto inputPacienteDto, @PathVariable Long id) {
        log.debug("Se recibio: " + inputPacienteDto + " para actualizar el paciente con el id " + id);

        try {
            Paciente paciente = mapper.convertValue(inputPacienteDto, Paciente.class);
            paciente.setId(id);
            pacienteService.actualizar(paciente);

        } catch (Exception exception) {
            log.error("Se produjo un error al intentar guardar el paciente", exception);
        }
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        log.debug("Se recibio la solicitud de eliminar el paciente con el id " + id);

        try {
            pacienteService.eliminar(id);

        } catch (Exception exception) {
            log.error("Se produjo un error al intentar eliminar el pacientecon el id " + id, exception);
        }
    }
}

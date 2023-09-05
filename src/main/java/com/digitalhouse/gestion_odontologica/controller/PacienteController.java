package com.digitalhouse.gestion_odontologica.controller;

import com.digitalhouse.gestion_odontologica.dto.ActualizarPaciente;
import com.digitalhouse.gestion_odontologica.dto.DomicilioDto;
import com.digitalhouse.gestion_odontologica.entity.Domicilio;
import com.digitalhouse.gestion_odontologica.service.IPacienteService;
import com.digitalhouse.gestion_odontologica.dto.NuevoPacienteDto;
import com.digitalhouse.gestion_odontologica.dto.PacienteResultadoDto;
import com.digitalhouse.gestion_odontologica.entity.Paciente;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
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
    public ResponseEntity<List<PacienteResultadoDto>> listar() {
        try {
            return ResponseEntity.ok(pacienteService.listarTodos()
                    .stream()
                    .map(paciente -> mapper.convertValue(paciente, PacienteResultadoDto.class))
                    .toList());
        } catch (Exception exception) {
            log.error("Se produjo un error al intentar listar todos los pacientes", exception);
            return ResponseEntity.internalServerError().build(); // todo improve return
        }
    }

    @PostMapping()
    public ResponseEntity<PacienteResultadoDto> guardar(@RequestBody NuevoPacienteDto nuevoPacienteDto) {
        log.debug("Se recibio: " + nuevoPacienteDto + " para guardar");

        try {
            Paciente paciente = pacienteService.guardar(mapper.convertValue(nuevoPacienteDto, Paciente.class));
            return ResponseEntity.ok(mapper.convertValue(paciente, PacienteResultadoDto.class));
        } catch (Exception exception) {
            log.error("Se produjo un error al intentar guardar el paciente", exception);
            return ResponseEntity.internalServerError().build(); // todo improve return
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResultadoDto> actualizar(@RequestBody ActualizarPaciente pacienteDto, @PathVariable Long id) {
        log.debug("Se recibio: " + pacienteDto + " para actualizar el paciente con el id " + id);

        try {
            Paciente paciente = mapper.convertValue(pacienteDto, Paciente.class);
            paciente.setId(id);
            paciente = pacienteService.actualizar(paciente);
            return ResponseEntity.ok(mapper.convertValue(paciente, PacienteResultadoDto.class));
        } catch (Exception exception) {
            log.error("Se produjo un error al intentar guardar el paciente", exception);
            return ResponseEntity.internalServerError().build(); // todo improve return
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        log.debug("Se recibio la solicitud de eliminar el paciente con el id " + id);

        try {
            pacienteService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception exception) {
            log.error("Se produjo un error al intentar eliminar el pacientecon el id " + id, exception);
            return ResponseEntity.internalServerError().build(); // todo improve return
        }
    }
}

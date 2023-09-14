package com.digitalhouse.gestion_odontologica.controller;

import com.digitalhouse.gestion_odontologica.dto.ActualizarPaciente;
import com.digitalhouse.gestion_odontologica.dto.DomicilioDto;
import com.digitalhouse.gestion_odontologica.dto.NuevoPacienteDto;
import com.digitalhouse.gestion_odontologica.dto.PacienteResultadoDto;
import com.digitalhouse.gestion_odontologica.entity.Domicilio;
import com.digitalhouse.gestion_odontologica.entity.Paciente;
import com.digitalhouse.gestion_odontologica.service.IPacienteService;
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
    public ResponseEntity<List<PacienteResultadoDto>> listar() {
        return ResponseEntity.ok(pacienteService.listarTodos()
                .stream()
                .map(paciente -> mapper.convertValue(paciente, PacienteResultadoDto.class))
                .toList());
    }

    @PostMapping()
    public ResponseEntity<PacienteResultadoDto> guardar(@RequestBody NuevoPacienteDto nuevoPacienteDto) {
        log.debug("Se recibio: " + nuevoPacienteDto + " para guardar");

        Paciente paciente = pacienteService.guardar(mapper.convertValue(nuevoPacienteDto, Paciente.class));
        return ResponseEntity.ok(mapper.convertValue(paciente, PacienteResultadoDto.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResultadoDto> actualizar(@RequestBody ActualizarPaciente pacienteDto, @PathVariable Long id) {
        log.debug("Se recibio: " + pacienteDto + " para actualizar el paciente con el id " + id);

        Paciente paciente = mapper.convertValue(pacienteDto, Paciente.class);
        paciente.setId(id);
        paciente = pacienteService.actualizar(paciente);
        return ResponseEntity.ok(mapper.convertValue(paciente, PacienteResultadoDto.class));
    }

    @PutMapping("/{id}/domicilio")
    public ResponseEntity<PacienteResultadoDto> actualizarDomicilio(@RequestBody DomicilioDto DomicilioDto,
                                                                    @PathVariable Long id) {
        log.debug("Se recibio: " + DomicilioDto + " para actualizar el domicilio del paciente con el id " + id);

        Domicilio domicilio = mapper.convertValue(DomicilioDto, Domicilio.class);
        Paciente paciente = pacienteService.actualizar(id, domicilio);
        return ResponseEntity.ok(mapper.convertValue(paciente, PacienteResultadoDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        log.debug("Se recibió la solicitud de eliminar el paciente con el id " + id);

        pacienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

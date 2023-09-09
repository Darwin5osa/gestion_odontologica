package com.digitalhouse.gestion_odontologica.controller;


import com.digitalhouse.gestion_odontologica.dto.ActualizarTurnoDto;
import com.digitalhouse.gestion_odontologica.dto.NuevoTurnoDto;
import com.digitalhouse.gestion_odontologica.dto.TurnoResultadoDto;
import com.digitalhouse.gestion_odontologica.entity.Turno;
import com.digitalhouse.gestion_odontologica.service.ITurnoService;
import com.digitalhouse.gestion_odontologica.util.Mapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/turno")

@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TurnoController {
    private final ITurnoService turnoService;
    private final ObjectMapper mapper;

    @GetMapping()
    public ResponseEntity<List<TurnoResultadoDto>> listar() {
        return ResponseEntity.ok(turnoService.listarTodos()
                .stream()
                .map(turno -> mapper.convertValue(turno, TurnoResultadoDto.class))
                .toList());
    }

    @PostMapping
    public ResponseEntity<TurnoResultadoDto> guardar(@RequestBody @Validated NuevoTurnoDto nuevoTurnoDto) {
        log.info("Se recibio: " + nuevoTurnoDto + " para guardar");

        Turno turno = turnoService.guardar(Mapper.map(nuevoTurnoDto));
        return ResponseEntity.ok(mapper.convertValue(turno, TurnoResultadoDto.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurnoResultadoDto> actualizar(@RequestBody ActualizarTurnoDto turnoDto, @PathVariable Long id) {
        log.debug("Se recibio: " + turnoDto + " para actualizar el turno con el id " + id);

        Turno turno = mapper.convertValue(turnoDto, Turno.class);
        turno.setId(id);
        turno = turnoService.actualizar(turno);
        return ResponseEntity.ok(mapper.convertValue(turno, TurnoResultadoDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        log.debug("Se recibio la solicitud de eliminar el turno con el id " + id);
        turnoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}

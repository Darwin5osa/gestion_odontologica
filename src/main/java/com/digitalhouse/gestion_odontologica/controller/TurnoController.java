package com.digitalhouse.gestion_odontologica.controller;


import com.digitalhouse.gestion_odontologica.dto.*;
import com.digitalhouse.gestion_odontologica.entity.Odontologo;
import com.digitalhouse.gestion_odontologica.entity.Turno;
import com.digitalhouse.gestion_odontologica.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<TurnoResultadoDto>> listar(){
        try{
            return ResponseEntity.ok(turnoService.listarTodos()
                    .stream()
                    .map(turno -> mapper.convertValue(turno, TurnoResultadoDto.class))
                     .toList());
        }catch (Exception exception){
            log.error("Se produjo un error al intentar listar todos los turnos", exception);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<TurnoResultadoDto> guardar(@RequestBody NuevoTurnoDto nuevoTurnoDto) {
        log.info("Se recibio: " + nuevoTurnoDto + " para guardar");

        try {
            Turno turno = turnoService.guardar(mapper.convertValue(nuevoTurnoDto, Turno.class));
            return ResponseEntity.ok(mapper.convertValue(turno, TurnoResultadoDto.class));
        } catch (Exception exception) {
            log.error("Se produjo un error al intentar guardar su turno", exception);
            return ResponseEntity.internalServerError().build(); // todo improve return
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurnoResultadoDto> actualizar(@RequestBody ActualizarTurnoDto turnoDto, @PathVariable Long id) {
        log.debug("Se recibio: " + turnoDto + " para actualizar el turno con el id " + id);

        try {
            Turno turno = mapper.convertValue(turnoDto, Turno.class);
            turno.setId(id);
           turno = turnoService.actualizar(turno);
            return ResponseEntity.ok(mapper.convertValue(turno, TurnoResultadoDto.class));
        } catch (Exception exception) {
            log.error("Se produjo un error al intentar guardar su nuevo turno", exception);
            return ResponseEntity.internalServerError().build(); // todo improve return
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        log.debug("Se recibio la solicitud de eliminar el turno con el id " + id);

        try {
            turnoService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception exception) {
            log.error("Se produjo un error al intentar eliminar el turno con el id " + id, exception);
            return ResponseEntity.internalServerError().build(); // todo improve return
        }
    }

}

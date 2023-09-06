package com.digitalhouse.gestion_odontologica.controller;

import com.digitalhouse.gestion_odontologica.dto.ActualizarOdontologoDto;
import com.digitalhouse.gestion_odontologica.dto.NuevoOdontologoDto;
import com.digitalhouse.gestion_odontologica.dto.OdontologoResultadoDto;
import com.digitalhouse.gestion_odontologica.entity.Odontologo;
import com.digitalhouse.gestion_odontologica.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/odontologo")
@RequiredArgsConstructor(onConstructor_ = @Autowired)

public class OdontologoController {
    private final IOdontologoService odontologoService;
    private final ObjectMapper mapper;

    @GetMapping()
    public ResponseEntity<List<OdontologoResultadoDto>> listar() {
        try {
            return ResponseEntity.ok(odontologoService.listarTodos()
                    .stream()
                    .map(odontologo -> mapper.convertValue(odontologo, OdontologoResultadoDto.class))
                    .toList());
        } catch (Exception exception) {
            log.error("Se produjo un error al intentar listar todos los odontologos", exception);
            return ResponseEntity.internalServerError().build(); // todo improve return
        }
    }

    @PostMapping()
    public ResponseEntity<OdontologoResultadoDto> guardar(@RequestBody NuevoOdontologoDto nuevoOdontologoDto) {
        log.info("Se recibio: " + nuevoOdontologoDto + " para guardar");

        try {
            Odontologo odontologo = odontologoService.guardar(mapper.convertValue(nuevoOdontologoDto, Odontologo.class));
            return ResponseEntity.ok(mapper.convertValue(odontologo, OdontologoResultadoDto.class));
        } catch (Exception exception) {
            log.error("Se produjo un error al intentar guardar el odontologo", exception);
            return ResponseEntity.internalServerError().build(); // todo improve return
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<OdontologoResultadoDto> actualizar(@RequestBody ActualizarOdontologoDto odontologoDto, @PathVariable Long id) {
        log.debug("Se recibio: " + odontologoDto + " para actualizar el odontologo con el id " + id);

        try {
            Odontologo odontologo = mapper.convertValue(odontologoDto, Odontologo.class);
            odontologo.setId(id);
            odontologo = odontologoService.actualizar(odontologo);
            return ResponseEntity.ok(mapper.convertValue(odontologo, OdontologoResultadoDto.class));
        } catch (Exception exception) {
            log.error("Se produjo un error al intentar guardar el odontologo", exception);
            return ResponseEntity.internalServerError().build(); // todo improve return
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        log.debug("Se recibio la solicitud de eliminar el odontologo con el id " + id);

        try {
            odontologoService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception exception) {
            log.error("Se produjo un error al intentar eliminar el odontologocon el id " + id, exception);
            return ResponseEntity.internalServerError().build(); // todo improve return
        }
    }
}
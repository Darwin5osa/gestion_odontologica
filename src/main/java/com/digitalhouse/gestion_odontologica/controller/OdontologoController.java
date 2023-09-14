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
        log.info("Se recibio una solicitud de listar todo");
        return ResponseEntity.ok(odontologoService.listarTodos()
                .stream()
                .map(odontologo -> mapper.convertValue(odontologo, OdontologoResultadoDto.class))
                .toList());
    }

    @PostMapping()
    public ResponseEntity<OdontologoResultadoDto> guardar(@RequestBody NuevoOdontologoDto nuevoOdontologoDto) {
        log.info("Se recibio: " + nuevoOdontologoDto + " para guardar");

        Odontologo odontologo = odontologoService.guardar(mapper.convertValue(nuevoOdontologoDto, Odontologo.class));
        return ResponseEntity.ok(mapper.convertValue(odontologo, OdontologoResultadoDto.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OdontologoResultadoDto> actualizar(@RequestBody ActualizarOdontologoDto odontologoDto, @PathVariable Long id) {
        log.info("Se recibio: " + odontologoDto + " para actualizar el odontologo con el id " + id);

        Odontologo odontologo = mapper.convertValue(odontologoDto, Odontologo.class);
        odontologo.setId(id);
        odontologo = odontologoService.actualizar(odontologo);
        return ResponseEntity.ok(mapper.convertValue(odontologo, OdontologoResultadoDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        log.info("Se recibio la solicitud de eliminar el odontologo con el id " + id);

        odontologoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologo")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
// todo todos entity result
public class OdontologoController {
    private final IOdontologoService odontologoService;
    private final ObjectMapper mapper;

    @GetMapping()
    public List<OdontologoResultadoDto> listarOdontologo() {
        try {
            return odontologoService.listarTodos()
                    .stream()
                    .map(odontologo -> mapper.convertValue(odontologo, OdontologoResultadoDto.class))
                    .toList();
        } catch (Exception exception) {
            log.error("Se produjo un error al intentar listar todos los odontologos", exception);
            return null;
        }
    }

    @PostMapping()
    public OdontologoResultadoDto guardarOdontologo(@RequestBody NuevoOdontologoDto nuevoOdontologoDto) {
        log.info("Se recibio: " + nuevoOdontologoDto + " para guardar");

        try {
            Odontologo odontologo = odontologoService.guardar(mapper.convertValue(nuevoOdontologoDto, Odontologo.class));
            return mapper.convertValue(odontologo, OdontologoResultadoDto.class);
        } catch (Exception exception) {
            log.error("Se produjo un error al intentar guardar el odontologo", exception);

        }
    }

    @PutMapping("/{id}")
    public OdontologoResultadoDto actualizar(@RequestBody ActualizarOdontologoDto odontologoDto, @PathVariable Long id) {
        log.debug("Se recibio: " + odontologoDto + " para actualizar el odontologo con el id " + id);

        try {
            Odontologo odontologo = mapper.convertValue(odontologoDto, Odontologo.class);
            odontologo.setId(id);
            odontologo = odontologoService.actualizar(odontologo);
            return mapper.convertValue(odontologo, OdontologoResultadoDto.class);
        } catch (Exception exception) {
            log.error("Se produjo un error al intentar guardar el odontologo", exception);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        log.debug("Se recibio la solicitud de eliminar el odontologo con el id " + id);

        try {
            odontologoService.eliminar(id);

        } catch (Exception exception) {
            log.error("Se produjo un error al intentar eliminar el odontologocon el id " + id, exception);
        }
    }
}
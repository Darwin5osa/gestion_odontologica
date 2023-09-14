package com.digitalhouse.gestion_odontologica.controller;

import com.digitalhouse.gestion_odontologica.dto.NuevoUsuarioDto;
import com.digitalhouse.gestion_odontologica.dto.UsuarioResultadoDto;
import com.digitalhouse.gestion_odontologica.entity.Usuario;
import com.digitalhouse.gestion_odontologica.entity.UsuarioRoleEnum;
import com.digitalhouse.gestion_odontologica.service.IUsuarioService;
import com.digitalhouse.gestion_odontologica.service.exception.RolUsuarioNoValidoException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UsuarioController {
    private final IUsuarioService usuarioService;
    private final ObjectMapper mapper;

    @GetMapping()
    public ResponseEntity<List<UsuarioResultadoDto>> listar() {
        return ResponseEntity.ok(usuarioService.listarTodos()
                .stream()
                .map(usuario -> mapper.convertValue(usuario, UsuarioResultadoDto.class))
                .toList());
    }

    @PostMapping()
    public ResponseEntity<UsuarioResultadoDto> guardar(@RequestBody NuevoUsuarioDto nuevoUsuarioDto) {
        log.info("Se recibio: " + nuevoUsuarioDto + " para guardar");
        validarRolUsuario(nuevoUsuarioDto.getRol());

        Usuario usuario = usuarioService.guardar(mapper.convertValue(nuevoUsuarioDto, Usuario.class));
        return ResponseEntity.ok(mapper.convertValue(usuario, UsuarioResultadoDto.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResultadoDto> actualizar(@RequestBody NuevoUsuarioDto usuarioDto, @PathVariable Long id) {
        log.info("Se recibio: " + usuarioDto + " para actualizar el usuario con el id " + id);
        validarRolUsuario(usuarioDto.getRol());

        Usuario usuario = mapper.convertValue(usuarioDto, Usuario.class);
        usuario.setId(id);
        usuario = usuarioService.actualizar(usuario);
        return ResponseEntity.ok(mapper.convertValue(usuario, UsuarioResultadoDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        log.info("Se recibió la solicitud de eliminar el usuario con el id " + id);

        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    private void validarRolUsuario(String rol) {
        try {
            UsuarioRoleEnum.valueOf(rol);
        } catch (IllegalArgumentException exception) {
            throw new RolUsuarioNoValidoException();
        }
    }
}
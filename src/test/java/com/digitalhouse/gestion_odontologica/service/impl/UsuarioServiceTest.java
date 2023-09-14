package com.digitalhouse.gestion_odontologica.service.impl;

import com.digitalhouse.gestion_odontologica.entity.Usuario;
import com.digitalhouse.gestion_odontologica.entity.UsuarioRoleEnum;
import com.digitalhouse.gestion_odontologica.repository.UsuarioRepository;
import com.digitalhouse.gestion_odontologica.service.IUsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;
    private Usuario usuario;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        usuarioService = new UsuarioService(usuarioRepository);
        usuario = new Usuario();
        usuario.setNombre("Agus");
        usuario.setUsername("agusaci");
        usuario.setEmail("agus.zaba@gmail.com");
        usuario.setPassword("39482");
        usuario.setRol(UsuarioRoleEnum.ROLE_USER);
    }

    @Test
    public void testGuardarUsuario() {

        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario resultado = usuarioService.guardar(usuario);

        assertNotNull(resultado);
        assertEquals(usuario, resultado);
    }

    @Test
    public void testEliminarUsuario() {
        // Arrange
        Long id = 1L;
        doNothing().when(usuarioRepository).deleteById(id);
        usuarioService.eliminar(id);

        verify(usuarioRepository, times(1)).deleteById(id);
    }


    @Test
    public void testListarTodosLosUsuarios() {
        // Arrange
        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario();
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        when(usuarioRepository.findAll()).thenReturn(usuarios);


        List<Usuario> usuariosEncontrados = usuarioService.listarTodos();


        assertNotNull(usuariosEncontrados);
        assertFalse(usuariosEncontrados.isEmpty());
        assertEquals(usuarios, usuariosEncontrados);
    }
}

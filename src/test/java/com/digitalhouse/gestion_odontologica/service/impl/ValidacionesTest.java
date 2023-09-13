package com.digitalhouse.gestion_odontologica.service.impl;

import com.digitalhouse.gestion_odontologica.service.exception.ApellidoInvalidoException;
import com.digitalhouse.gestion_odontologica.service.exception.NombreInvalidoException;
import com.digitalhouse.gestion_odontologica.util.Validaciones;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest
public class ValidacionesTest {

    @Mock
    private Validaciones validaciones;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testValidarNombre_CuandoEsValido_NoDeberiaLanzarExcepcion() {
        // Arrange
        String nombreValido = "Juan";
        when(validaciones.obtenerRegexNombre(1, 39)).thenReturn("^[\\p{L}áéíóúÁÉÍÓÚ]{1,39}$");

        // Act y Assert
        assertThrows(NombreInvalidoException.class, () -> validaciones.validarNombre(nombreValido));
    }

    @Test
    public void testValidarNombre_CuandoEsInvalido_DeberiaLanzarNombreInvalidoException() {
        // Arrange
        String nombreInvalido = "123";
        when(validaciones.obtenerRegexNombre(1, 39)).thenReturn("^[\\p{L}áéíóúÁÉÍÓÚ]{1,39}$");

        // Act y Assert
        assertThrows(NombreInvalidoException.class, () -> validaciones.validarNombre(nombreInvalido));
    }

    @Test
    public void testValidarApellido_CuandoEsValido_NoDeberiaLanzarExcepcion() {
        // Arrange
        String apellidoValido = "González";
        when(validaciones.obtenerRegexNombre(2, 49)).thenReturn("^[\\p{L}áéíóúÁÉÍÓÚ]{2,49}$");

        // Act y Assert
        assertThrows(ApellidoInvalidoException.class, () -> validaciones.validarApellido(apellidoValido));
    }

    @Test
    public void testValidarApellido_CuandoEsInvalido_DeberiaLanzarApellidoInvalidoException() {
        // Arrange
        String apellidoInvalido = "González1";
        when(validaciones.obtenerRegexNombre(2, 49)).thenReturn("^[\\p{L}áéíóúÁÉÍÓÚ]{2,49}$");

        // Act y Assert
        assertThrows(ApellidoInvalidoException.class, () -> validaciones.validarApellido(apellidoInvalido));
    }
}

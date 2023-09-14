package com.digitalhouse.gestion_odontologica.service.impl;

import com.digitalhouse.gestion_odontologica.service.exception.ApellidoInvalidoException;
import com.digitalhouse.gestion_odontologica.service.exception.NombreInvalidoException;
import com.digitalhouse.gestion_odontologica.util.Validaciones;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class ValidacionesTest {

    @Test
    public void testValidarNombre_CuandoEsValido_NoDeberiaLanzarExcepcion() {

        String nombreValido = "Juan";


        try {
            Validaciones.validarNombre(nombreValido);
        } catch (NombreInvalidoException e) {

            assert false;
        }
    }

    @Test
    public void testValidarNombre_CuandoEsInvalido_DeberiaLanzarNombreInvalidoException() {
        // Arrange
        String nombreInvalido = "123";


        try {
            Validaciones.validarNombre(nombreInvalido);

            assert false;
        } catch (NombreInvalidoException e) {

        }
    }

    @Test
    public void testValidarApellido_CuandoEsValido_NoDeberiaLanzarExcepcion() {

        String apellidoValido = "González";


        try {
            Validaciones.validarApellido(apellidoValido);
        } catch (ApellidoInvalidoException e) {
            // Si entra aquí, la prueba falla ya que no debería lanzar la excepción
            assert false;
        }
    }

    @Test
    public void testValidarApellido_CuandoEsInvalido_DeberiaLanzarApellidoInvalidoException() {

        String apellidoInvalido = "González1";


        try {
            Validaciones.validarApellido(apellidoInvalido);

            assert false;
        } catch (ApellidoInvalidoException e) {

        }
    }
}
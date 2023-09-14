package com.digitalhouse.gestion_odontologica.service.impl;

import com.digitalhouse.gestion_odontologica.entity.Odontologo;
import com.digitalhouse.gestion_odontologica.repository.OdontolgoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class OdontologoServiceTest {
    @Mock
    private OdontolgoRepository odontologoRepository;

    private OdontologoService odontologoService;

    private Odontologo odontologo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        odontologoService = new OdontologoService(odontologoRepository);
        odontologo = new Odontologo();
        odontologo.setNombre("Agustina");
        odontologo.setApellido("Zabaleta");
        odontologo.setMatricula(23344);
    }

    @Test
    public void testGuardarOdontologo() {
        Odontologo expectedOdontologo = new Odontologo(1L, odontologo.getNombre(), odontologo.getApellido(), odontologo.getMatricula(), new ArrayList<>());

        when(odontologoRepository.save(any())).thenReturn(expectedOdontologo);

        // Act
        Odontologo resultado = odontologoService.guardar(odontologo);

        // Assert
        assertNotNull(resultado);
        assertEquals(expectedOdontologo, resultado);
    }

    @Test
    public void testEliminarOdontologo() {
        Long id = 1L;

        // Act
        odontologoService.eliminar(id);

        // Assert
        // Verifica que el repositorio se haya llamado para eliminar el odontologo por su ID
        verify(odontologoRepository, times(1)).deleteById(id);
    }

    @Test
    public void testActualizarOdontologo() {
        Long id = 1L;
        odontologo.setId(id);

        // Configura el comportamiento del repositorio mock
        when(odontologoRepository.findById(any())).thenReturn(Optional.of(odontologo));
        doNothing().when(odontologoRepository).update(any(), any(), anyString());

        // Llama al método del servicio para actualizar el odontologo
        Odontologo resultado = odontologoService.actualizar(odontologo);

        // Verifica que el repositorio se haya llamado para obtener el odontologo por su ID
        verify(odontologoRepository, times(1)).findById(id);
        // Verifica que el repositorio se haya llamado para guardar el odontologo actualizado
        verify(odontologoRepository, times(1)).update(any(), any(), anyString());
        // Verifica que el resultado sea el mismo odontologo actualizado
        assertEquals(odontologo, resultado);
    }

    @Test
    public void testListarTodosLosOdontologos() {
        // Configura tus objetos mock y comportamientos aquí según sea necesario
        Odontologo odontologo1 = new Odontologo();
        Odontologo odontologo2 = new Odontologo();
        List<Odontologo> odontologos = Arrays.asList(odontologo1, odontologo2);

        when(odontologoRepository.findAll()).thenReturn(odontologos);

        // Act
        List<Odontologo> odontologosEncontrados = odontologoService.listarTodos();

        // Assert
        assertNotNull(odontologosEncontrados);
        assertFalse(odontologosEncontrados.isEmpty());
        assertEquals(odontologos, odontologosEncontrados);
    }
}

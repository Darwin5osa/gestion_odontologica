package com.digitalhouse.gestion_odontologica.service.impl;

import com.digitalhouse.gestion_odontologica.entity.Domicilio;
import com.digitalhouse.gestion_odontologica.entity.Paciente;
import com.digitalhouse.gestion_odontologica.repository.DomicilioRepository;
import com.digitalhouse.gestion_odontologica.repository.PacienteRepository;
import com.digitalhouse.gestion_odontologica.service.impl.PacienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PacienteServiceTest {

    @InjectMocks
    private PacienteService pacienteService;

    @Mock
    private PacienteRepository pacienteRepository;

    @Mock
    private DomicilioRepository domicilioRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGuardarPaciente() {
        // Configura tus objetos mock y comportamientos aquí según sea necesario
        Domicilio domicilio = new Domicilio();
        Paciente paciente = new Paciente();
        paciente.setDomicilio(domicilio);

        when(domicilioRepository.save(domicilio)).thenReturn(domicilio);
        when(pacienteRepository.save(paciente)).thenReturn(paciente);

        // Act
        Paciente resultado = pacienteService.guardar(paciente);

        // Assert
        assertNotNull(resultado);
        assertEquals(domicilio, resultado.getDomicilio());
    }

    @Test
    public void testEliminarPaciente() {
        Long id = 1L;

        // Act
        pacienteService.eliminar(id);

        // Assert
        // Verifica que el repositorio se haya llamado para eliminar el paciente por su ID
        verify(pacienteRepository, times(1)).deleteById(id);
    }

    @Test
    public void testActualizarPaciente() {
        Long id = 1L;
        Paciente paciente = new Paciente();
        paciente.setId(id);

        // Configura el comportamiento del repositorio mock
        when(pacienteRepository.findById(id)).thenReturn(Optional.of(paciente));
        when(pacienteRepository.save(paciente)).thenReturn(paciente);

        // Llama al método del servicio para actualizar el paciente
        Paciente resultado = pacienteService.actualizar(paciente);

        // Verifica que el repositorio se haya llamado para obtener el paciente por su ID
        verify(pacienteRepository, times(1)).findById(id);
        // Verifica que el repositorio se haya llamado para guardar el paciente actualizado
        verify(pacienteRepository, times(1)).save(paciente);
        // Verifica que el resultado sea el mismo paciente actualizado
        assertEquals(paciente, resultado);
    }

    @Test
    public void testListarTodosLosPacientes() {
        // Configura tus objetos mock y comportamientos aquí según sea necesario
        Paciente paciente1 = new Paciente();
        Paciente paciente2 = new Paciente();
        List<Paciente> pacientes = Arrays.asList(paciente1, paciente2);

        when(pacienteRepository.findAll()).thenReturn(pacientes);

        // Act
        List<Paciente> pacientesEncontrados = pacienteService.listarTodos();

        // Assert
        assertNotNull(pacientesEncontrados);
        assertFalse(pacientesEncontrados.isEmpty());
        assertEquals(pacientes, pacientesEncontrados);
    }
}

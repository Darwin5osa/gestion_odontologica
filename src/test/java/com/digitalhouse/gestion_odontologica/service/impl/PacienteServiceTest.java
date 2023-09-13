package com.digitalhouse.gestion_odontologica.service.impl;
import com.digitalhouse.gestion_odontologica.entity.Domicilio;
import com.digitalhouse.gestion_odontologica.entity.Paciente;
import com.digitalhouse.gestion_odontologica.repository.DomicilioRepository;
import com.digitalhouse.gestion_odontologica.repository.PacienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
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
public class PacienteServiceTest {

    @Mock
    private PacienteRepository pacienteRepository;
    @InjectMocks
    private PacienteService pacienteService;
    private Paciente paciente;

    private  Domicilio domicilio;
    @Mock
    private DomicilioRepository domicilioRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        pacienteService = new PacienteService(pacienteRepository, domicilioRepository);
        paciente = new Paciente();
        domicilio= new Domicilio();
        paciente.setNombre("Fabricio");
        paciente.setApellido("Gutierrez");
        domicilio.setCalle("Almiron");
        domicilio.setCiudad("Montevideo");
        domicilio.setDepartamento("Montevideo");
        domicilio.setPais("Uruguay");
        domicilio.setPaciente(paciente);
        paciente.setDomicilio(domicilio);
}
    @Test
    public void testGuardarPaciente() {

        Domicilio expectedDomicilio = new Domicilio(1L, domicilio.getNumPuerta(), domicilio.getCalle(), domicilio.getCiudad(), domicilio.getDepartamento(), domicilio.getPais(), new Paciente());
        Paciente expectedPaciente = new Paciente(1L, paciente.getNombre(), paciente.getApellido(), paciente.getDni(),paciente.getFechaIngreso(), expectedDomicilio, new ArrayList<>());

        when(domicilioRepository.save(any())).thenReturn(expectedDomicilio);
        when(pacienteRepository.save(any())).thenReturn(expectedPaciente);

        // Act
        Paciente resultado = pacienteService.guardar(paciente);

        // Assert
        assertNotNull(resultado);
        assertEquals(expectedPaciente, resultado);
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
        paciente.setId(id);

        // Configura el comportamiento del repositorio mock
        when(pacienteRepository.findById(any())).thenReturn(Optional.of(paciente));
        when(pacienteRepository.save(paciente)).thenReturn(paciente);	        doNothing().when(pacienteRepository).update(any(), any(), any());

        // Llama al método del servicio para actualizar el paciente
        Paciente resultado = pacienteService.actualizar(paciente);

        // Verifica que el repositorio se haya llamado para obtener el paciente por su ID
        verify(pacienteRepository, times(1)).findById(id);
        // Verifica que el repositorio se haya llamado para guardar el paciente actualizado
        verify(pacienteRepository, times(1)).update(any(), any(), any());
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

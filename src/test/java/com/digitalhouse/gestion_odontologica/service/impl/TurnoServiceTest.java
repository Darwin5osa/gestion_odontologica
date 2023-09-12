package com.digitalhouse.gestion_odontologica.service.impl;

import com.digitalhouse.gestion_odontologica.entity.Paciente;
import com.digitalhouse.gestion_odontologica.entity.Turno;
import com.digitalhouse.gestion_odontologica.repository.OdontolgoRepository;
import com.digitalhouse.gestion_odontologica.repository.PacienteRepository;
import com.digitalhouse.gestion_odontologica.repository.TurnoRepository;
import com.digitalhouse.gestion_odontologica.service.impl.TurnoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest

public class TurnoServiceTest{

    @InjectMocks
    private TurnoService turnoService;

    @Mock
    private TurnoRepository turnoRepository;

    @Mock
    private PacienteRepository pacienteRepository;

    @Mock
    private OdontolgoRepository odontolgoRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGuardarTurno() {
        Turno turno = new Turno();
        // Configura tus objetos mock y comportamientos aquí según sea necesario

        // Ejemplo: Cuando se llama a pacienteRepository.findById, devuelve un paciente ficticio
        when(pacienteRepository.findById(anyLong())).thenReturn(Optional.of(new Paciente()));

        // Act
        Turno resultado = turnoService.guardar(turno);

        // Assert
        // Asegúrate de que se haya llamado al método save del turnoRepository
        verify(turnoRepository, times(1)).save(turno);
        // Añade más afirmaciones según tu caso
    }

    @Test
    public void testListarTodosLosTurnos() {
        // Configura tus objetos mock y comportamientos aquí según sea necesario
        when(turnoRepository.findAll()).thenReturn(Collections.emptyList());

        // Act
        List<Turno> turnos = turnoService.listarTodos();

        // Assert
        // Añade afirmaciones según tu caso, por ejemplo, verifica que la lista no esté vacía
        assertTrue(turnos.isEmpty());
    }
    @Test
    public void testActualizarTurno() {
        Long id = 1L;
        Turno turno = new Turno();
        turno.setId(id);

        // Configura el comportamiento del repositorio mock
        when(turnoRepository.findById(id)).thenReturn(Optional.of(turno));
        when(turnoRepository.save(turno)).thenReturn(turno);

        // Llama al método del servicio para actualizar el turno
        Turno resultado = turnoService.actualizar(turno);

        // Verifica que el repositorio se haya llamado para obtener el turno por su ID
        verify(turnoRepository, times(1)).findById(id);
        // Verifica que el repositorio se haya llamado para guardar el turno actualizado
        verify(turnoRepository, times(1)).save(turno);
        // Verifica que el resultado sea el mismo turno actualizado
        assertEquals(turno, resultado);
    }

@Test
    public void testEliminarTurnoPorId() {
        Long id = 1L;

        // Llama al método del servicio
        turnoService.eliminar(id);

        // Verifica que el repositorio se haya llamado para eliminar el turno por su ID
        verify(turnoRepository, times(1)).deleteById(id);
    }
}


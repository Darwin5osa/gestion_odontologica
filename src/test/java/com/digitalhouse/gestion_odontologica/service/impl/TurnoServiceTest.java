package com.digitalhouse.gestion_odontologica.service.impl;

import com.digitalhouse.gestion_odontologica.entity.Odontologo;
import com.digitalhouse.gestion_odontologica.entity.Paciente;
import com.digitalhouse.gestion_odontologica.entity.Turno;
import com.digitalhouse.gestion_odontologica.repository.OdontolgoRepository;
import com.digitalhouse.gestion_odontologica.repository.PacienteRepository;
import com.digitalhouse.gestion_odontologica.repository.TurnoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest

public class TurnoServiceTest{

    @Mock
    private TurnoRepository turnoRepository;

    @Mock
    private PacienteRepository pacienteRepository;

    @Mock
    private OdontolgoRepository odontolgoRepository;

    private Turno turno;

    private  Paciente paciente;

    private  Odontologo odontologo;

    private  TurnoService turnoService;

    @BeforeEach
    public void setUp() throws ParseException {
        MockitoAnnotations.openMocks(this);
        turnoService = new TurnoService(turnoRepository, pacienteRepository, odontolgoRepository);
        turno = new Turno();
        paciente = new Paciente();
        odontologo = new Odontologo();
        turno.setFecha(new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss").parse("2023-10-06T12:00:00"));
        paciente.setId(1L);
        odontologo.setId(1L);
        turno.setPaciente(paciente);
        turno.setOdontologo(odontologo);

    }

    @Test
    public void testGuardarTurno() {
            Turno expectedTurno = new Turno(1L, turno.getFecha(), turno.getPaciente(), turno.getOdontologo());
        // Configura tus objetos mock y comportamientos aquí según sea necesario

        // Ejemplo: Cuando se llama a pacienteRepository.findById, devuelve un paciente ficticio
        when(pacienteRepository.findById(any())).thenReturn(Optional.of(paciente));
        when(odontolgoRepository.findById(any())).thenReturn(Optional.of(odontologo));
        when(turnoRepository.save(any())).thenReturn(expectedTurno);

        // Act
        Turno resultado = turnoService.guardar(turno);

        // Assert
        assertNotNull(resultado);
        assertEquals(expectedTurno, resultado);
        // Asegúrate de que se haya llamado al método save del turnoRepository
        verify(turnoRepository, times(1)).save(turno);
        // Añade más afirmaciones según tu caso
    }

    @Test
    public void testListarTodosLosTurnos() {
        // Configura tus objetos mock y comportamientos aquí según sea necesario

            Turno turno1 = new Turno();
            Turno turno2 = new Turno();
            List<Turno> turnos = Arrays.asList(turno1, turno2);
            when(turnoRepository.findAll()).thenReturn(turnos);

        // Act
        List<Turno> turnosEncontrados = turnoService.listarTodos();

        // Assert

            assertNotNull(turnosEncontrados);
            assertFalse(turnosEncontrados.isEmpty());
            assertEquals(turnos, turnosEncontrados);
        // Añade afirmaciones según tu caso, por ejemplo, verifica que la lista no esté vacía
        assertFalse(turnos.isEmpty());
    }
    @Test
    public void testActualizarTurno() {
        Long id = 1L;
        turno.setId(id);

        // Configura el comportamiento del repositorio mock
        when(turnoRepository.findById(any())).thenReturn(Optional.of(turno));
        when(pacienteRepository.findById(any())).thenReturn(Optional.of(paciente));
        when(odontolgoRepository.findById(any())).thenReturn(Optional.of(odontologo));
        doNothing().when(turnoRepository).update(any(), any(), any(), any());


        // Llama al método del servicio para actualizar el turno
        Turno resultado = turnoService.actualizar(turno);

        // Verifica que el repositorio se haya llamado para obtener el turno por su ID
        verify(turnoRepository, times(1)).findById(id);
        // Verifica que el repositorio se haya llamado para guardar el turno actualizado
        verify(turnoRepository, times(1)).update(any(), any(), any(), any());
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


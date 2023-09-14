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

        when(pacienteRepository.findById(any())).thenReturn(Optional.of(paciente));
        when(odontolgoRepository.findById(any())).thenReturn(Optional.of(odontologo));
        when(turnoRepository.save(any())).thenReturn(expectedTurno);

        Turno resultado = turnoService.guardar(turno);

        assertNotNull(resultado);
        assertEquals(expectedTurno, resultado);
        verify(turnoRepository, times(1)).save(turno);
    }

    @Test
    public void testListarTodosLosTurnos() {

            Turno turno1 = new Turno();
            Turno turno2 = new Turno();
            List<Turno> turnos = Arrays.asList(turno1, turno2);
            when(turnoRepository.findAll()).thenReturn(turnos);

        List<Turno> turnosEncontrados = turnoService.listarTodos();

            assertNotNull(turnosEncontrados);
            assertFalse(turnosEncontrados.isEmpty());
            assertEquals(turnos, turnosEncontrados);
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


        Turno resultado = turnoService.actualizar(turno);

        verify(turnoRepository, times(1)).findById(id);
        verify(turnoRepository, times(1)).update(any(), any(), any(), any());
        assertEquals(turno, resultado);
    }

@Test
    public void testEliminarTurnoPorId() {
        Long id = 1L;
        turnoService.eliminar(id);

        verify(turnoRepository, times(1)).deleteById(id);
    }
}


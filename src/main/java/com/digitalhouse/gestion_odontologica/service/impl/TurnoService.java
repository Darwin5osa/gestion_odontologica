package com.digitalhouse.gestion_odontologica.service.impl;

import com.digitalhouse.gestion_odontologica.service.ITurnoService;
import com.digitalhouse.gestion_odontologica.entity.Turno;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TurnoService implements ITurnoService {

    @Override
    public void guardar(Turno turno) throws Exception {

    }

    @Override
    public List<Turno> listarTodos() throws Exception {
        return null;
    }

    @Override
    public void actualizar(Turno turno) throws Exception {

    }

    @Override
    public void eliminar(int dni) throws Exception {

    }
}

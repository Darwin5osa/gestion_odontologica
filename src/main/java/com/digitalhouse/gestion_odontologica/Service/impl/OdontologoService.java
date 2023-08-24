package com.digitalhouse.gestion_odontologica.Service.impl;

import com.digitalhouse.gestion_odontologica.DAOs.IDao;
import com.digitalhouse.gestion_odontologica.Service.IOdontologoService;
import com.digitalhouse.gestion_odontologica.model.Odontologo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OdontologoService implements IOdontologoService {

    private final IDao<Odontologo> odontologoDao;

    @Autowired
    public OdontologoService(IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public void guardar(Odontologo odontologo) {
        try {
            odontologoDao.guardar(odontologo);
            log.debug("Se guardo el odontologo");
        } catch (Exception e) {
            log.error("No se pudo guardar el odontologo", e);
        }
    }

    public List<Odontologo> listarTodos() {
        try {
            return odontologoDao.listarTodos();
        } catch (Exception e) {
            log.error("No se pudo agregar el odontólogo", e);
            return null;
        }
    }

    @Override
    public void actualizar(Odontologo odontologo) throws Exception {
        //todo
    }

    @Override
    public void eliminar(int matricula) throws Exception {
        //todo
    }
}
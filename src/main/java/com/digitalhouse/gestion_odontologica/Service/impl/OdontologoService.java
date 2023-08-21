package com.digitalhouse.gestion_odontologica.Service.impl;

import com.digitalhouse.gestion_odontologica.DAOs.IOdontologoDAO;
import com.digitalhouse.gestion_odontologica.Service.IOdontologoService;
import com.digitalhouse.gestion_odontologica.model.Odontologo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OdontologoService implements IOdontologoService {

    private final IOdontologoDAO odontologoDao;

    @Autowired
    public OdontologoService(IOdontologoDAO odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public boolean guardar(Odontologo odontologo) {
        try {
            odontologoDao.guardar(odontologo);
            log.debug("Se guardo el odontologo");
            return true;
        } catch (Exception e) {
            log.error("No se pudo guardar el odontologo", e);
            return false;
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
}
package com.digitalhouse.gestion_odontologica.service.impl;

import com.digitalhouse.gestion_odontologica.service.IOdontologoService;
import com.digitalhouse.gestion_odontologica.entity.Odontologo;
import com.digitalhouse.gestion_odontologica.repository.OdontolgoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class OdontologoService implements IOdontologoService {

    private final OdontolgoRepository odontologoReository;
    private final ObjectMapper mapper;

    public void guardar(Odontologo odontologo) {
        try {
            odontologoReository.save(odontologo);
            log.debug("Se guardo el odontologo");
        } catch (Exception e) {
            log.error("No se pudo guardar el odontologo", e);
        }
    }

    public List<Odontologo> listarTodos() {
        try {
            return odontologoReository.findAll();
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
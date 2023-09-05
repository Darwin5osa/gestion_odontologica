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

    public Odontologo guardar(Odontologo odontologo) {
        try {
            odontologo = odontologoReository.save(odontologo);
            log.debug("Se guardo el odontologo");
            return  odontologo;
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
    public Odontologo actualizar(Odontologo odontologo) throws Exception {
        return odontologoReository.update(odontologo.getId(), odontologo.getNombre(), odontologo.getApellido());
    }

    @Override
    public void eliminar(Long id) throws Exception {
        odontologoReository.deleteById(id);
    }
}
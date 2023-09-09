package com.digitalhouse.gestion_odontologica.service.impl;

import com.digitalhouse.gestion_odontologica.entity.Odontologo;
import com.digitalhouse.gestion_odontologica.repository.OdontolgoRepository;
import com.digitalhouse.gestion_odontologica.service.IOdontologoService;
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
        Validaciones.validarNombre(odontologo.getNombre());
        Validaciones.validarApellido(odontologo.getApellido());

        odontologo = odontologoReository.save(odontologo);
        log.debug("Se guardo el odontologo");
        return odontologo;
    }

    public List<Odontologo> listarTodos() {
        return odontologoReository.findAll();
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        Validaciones.validarNombre(odontologo.getNombre());
        Validaciones.validarApellido(odontologo.getApellido());

        odontologoReository.update(odontologo.getId(), odontologo.getNombre(), odontologo.getApellido());
        return obtenerUnoPorId(odontologo.getId());
    }

    @Override
    public Odontologo obtenerUnoPorId(Long id) {
        return odontologoReository.findById(id).orElseThrow();
    }

    @Override
    public void eliminar(Long id) {
        odontologoReository.deleteById(id);
    }
}
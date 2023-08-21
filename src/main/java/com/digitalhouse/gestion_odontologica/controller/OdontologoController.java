package com.digitalhouse.gestion_odontologica.controller;

import com.digitalhouse.gestion_odontologica.Service.IOdontologoService;
import com.digitalhouse.gestion_odontologica.model.Odontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {
    private final IOdontologoService odontologoService;

    @Autowired
    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping()
    public List<Odontologo> getAllOdontologo() {
        return odontologoService.listarTodos();
    }

    @PostMapping()
    public String insertOdontologo() {
        if (odontologoService.guardar(new Odontologo(1,"",""))) {
            return "Guardado";
        } else return "No se guardo";
    }
}
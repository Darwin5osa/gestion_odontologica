package com.digitalhouse.gestion_odontologica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping
    public String redirect (){
        return "index.html";
    }
}

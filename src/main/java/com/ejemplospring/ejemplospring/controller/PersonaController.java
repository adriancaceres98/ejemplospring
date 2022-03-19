package com.ejemplospring.ejemplospring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {

    @GetMapping
    public String hola() {
        return "Hola !";
    }

}

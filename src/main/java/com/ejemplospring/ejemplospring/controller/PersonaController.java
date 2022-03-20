package com.ejemplospring.ejemplospring.controller;

import com.ejemplospring.ejemplospring.dto.PersonaDto;
import com.ejemplospring.ejemplospring.dto.ResponseDto;
import com.ejemplospring.ejemplospring.service.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {

    @GetMapping
    public String hola() {
        return "Hola !";
    }

    @GetMapping("/{nombre}")
    public String holaNombre(@PathVariable String nombre) {
        return "Hola " + nombre + " como estas ? ";
    }

    @GetMapping("/{nombre}/{edad}")
    public String holaNombre(@PathVariable String nombre, @PathVariable int edad) {
        return "Hola " + nombre + " como estas ? tenes " + edad + " años ";
    }

    @GetMapping(path = "/persona")
    public String holaPersona(@RequestParam String nombre, @RequestParam String apellido) {
        return "Tu nombre es " + nombre + " apellido " + apellido;
    }

    // con wrappers
    @GetMapping(path = "/numero")
    public String holaPersona(@RequestParam Integer numero) {
        return "Su numero es " +  numero;
    }

    // con lombok y dto

    @GetMapping("/dto")
    public String dto(@RequestParam String nombre, @RequestParam String apellido) {
        PersonaDto personaDto = new PersonaDto(nombre,apellido);
        return personaDto.getNombre() + " " + personaDto.getApellido();
    }

    // inversion de control
    @GetMapping("dtoinversioncontrol")
    public PersonaDto dtoinv(@RequestParam String nombre, @RequestParam String apellido) {
        PersonaDto personaDto = new PersonaDto(nombre,apellido);
        return personaDto;
    }

    // con servicios
    @GetMapping("conservicio")
    public ResponseDto conServicio(@RequestParam String nombre, @RequestParam String apellido) {
        PersonaDto personaDto = new PersonaDto(nombre,apellido);
        PersonaService personaService = new PersonaService();
        return personaService.crearRespuesta(personaDto);
    }

}

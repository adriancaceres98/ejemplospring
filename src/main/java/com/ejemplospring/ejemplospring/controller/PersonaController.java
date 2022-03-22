package com.ejemplospring.ejemplospring.controller;

import com.ejemplospring.ejemplospring.dto.PersonaDto;
import com.ejemplospring.ejemplospring.dto.ResponseDto;
import com.ejemplospring.ejemplospring.service.PersonaService;
import com.ejemplospring.ejemplospring.service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PersonaController {
    //@Autowired
    //PersonaServiceImpl personaServiceImpl;

    @Autowired
    PersonaService personaService;


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

    @GetMapping("/conservicio")
    public ResponseDto conServicio(@RequestParam String nombre, @RequestParam String apellido) {
        PersonaDto personaDto = new PersonaDto(nombre,apellido);
        PersonaServiceImpl personaService = new PersonaServiceImpl();
        return personaService.crearRespuesta(personaDto);
    }

    @GetMapping("/conresponseentity")
    public ResponseEntity<ResponseDto> conresponseentity(@RequestParam String nombre, @RequestParam String apellido) {
        PersonaDto personaDto = new PersonaDto(nombre,apellido);
        PersonaServiceImpl personaService = new PersonaServiceImpl();
        return new ResponseEntity<ResponseDto>(personaService.crearRespuesta(personaDto), HttpStatus.OK);
    }

    // con response entity
    // metodo post
    @PostMapping("/personadto")
    public PersonaDto postPersona(@RequestBody PersonaDto personaDtoPost) {
        PersonaDto personaDto = new PersonaDto(personaDtoPost.getNombre(),personaDtoPost.getApellido());
        return personaDto;
    }

    // con servicios
    @GetMapping("/conresponseentitygetpersonas")
    public ArrayList<PersonaDto> getPersonas() {
        PersonaServiceImpl personaServiceImpl = new PersonaServiceImpl();
        return personaServiceImpl.getPersonas();
    }


/*
    @GetMapping("/conresponseentitygetpersonas")
    public ResponseEntity<ArrayList<PersonaDto>> conresponseentitygetpersonas() {
        PersonaServiceImpl personaServiceImpl = new PersonaServiceImpl();
        return new ResponseEntity<ArrayList<PersonaDto>>(personaServiceImpl.getPersonas(), HttpStatus.OK);
    }
*/

    // sin autowired
    @GetMapping("/getpersonassinautowired")
    public ArrayList<PersonaDto> getPersonasSinautowired() {
        PersonaServiceImpl personaServiceImpl = new PersonaServiceImpl();
        return personaServiceImpl.getPersonas();
    }

    // con autowired, llama a servicio
    @GetMapping("/getpersonasconautowired")
    public ArrayList<PersonaDto> getPersonasConautowired() {
        return personaService.getPersonas();
    }

    // con autowired en servicios llamando a repositori
    @GetMapping("/getpersonasconautowired_repo")
    public ArrayList<PersonaDto> getPersonasConautowiredRepo() {
        return personaService.getPersonas();
    }

}

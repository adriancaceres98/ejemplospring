package com.ejemplospring.ejemplospring.service;

import com.ejemplospring.ejemplospring.dto.PersonaDto;
import com.ejemplospring.ejemplospring.dto.ResponseDto;

import java.util.ArrayList;


public interface PersonaService {
    public ResponseDto crearRespuesta(PersonaDto personaDto);

    public ArrayList<PersonaDto> getPersonas();

    public ArrayList<PersonaDto> getPersonasAutowired();

}

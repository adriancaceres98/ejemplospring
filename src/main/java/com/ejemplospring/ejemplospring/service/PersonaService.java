package com.ejemplospring.ejemplospring.service;

import com.ejemplospring.ejemplospring.dto.PersonaDto;
import com.ejemplospring.ejemplospring.dto.ResponseDto;

public class PersonaService {

    public ResponseDto crearRespuesta(PersonaDto personaDto) {
        ResponseDto responseDto = new ResponseDto(personaDto.getNombre(), personaDto.getApellido());
        return responseDto;
    }

}

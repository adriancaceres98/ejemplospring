package com.ejemplospring.ejemplospring.service;

import com.ejemplospring.ejemplospring.dto.PersonaDto;
import com.ejemplospring.ejemplospring.dto.ResponseDto;
import com.ejemplospring.ejemplospring.repository.PersonaDao;
import com.ejemplospring.ejemplospring.repository.PersonaDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    PersonaDao personaDao;

    @Override
    public ResponseDto crearRespuesta(PersonaDto personaDto) {
        ResponseDto responseDto = new ResponseDto(personaDto.getNombre(), personaDto.getApellido());
        return responseDto;
    }

    @Override
    public ArrayList<PersonaDto> getPersonas() {
        PersonaDaoImpl personaDaoImpl = new PersonaDaoImpl();
        return personaDaoImpl.getPersonas();
    }

    @Override
    public ArrayList<PersonaDto> getPersonasAutowired() {
        return personaDao.getPersonas();
    }


}

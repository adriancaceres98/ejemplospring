package com.ejemplospring.ejemplospring.repository;

import com.ejemplospring.ejemplospring.dto.PersonaDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class PersonaDaoImpl implements PersonaDao{

    @Override
    public ArrayList<PersonaDto> getPersonas() {
        ArrayList<PersonaDto> personas = new ArrayList<>();
        personas.add(new PersonaDto("Juan","Gomez"));
        personas.add(new PersonaDto("Pedro","Perez"));
        return personas;
    }
}

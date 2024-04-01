package com.venturicg.poc.service.impl;


import com.venturicg.poc.repository.PersonaDAO;
import com.venturicg.poc.service.PersonasService;
import com.venturicg.poc.service.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonasService {

    @Autowired
    private PersonaDAO personaDAO;

    @Override
    public List<Persona> obtenerPersonas() {
        return personaDAO.obtenerPersonas();
    }

    @Override
    public List<Persona> findAll() {
        return personaDAO.findAll();
    }

    @Override
    public Persona findById(int id) {
        return personaDAO.findById(id);
    }

    @Override
    public Persona save(Persona persona) {
        personaDAO.insert(persona);
        return persona;
    }

    @Override
    public Persona update(int id, Persona persona) {
        persona.setId(id);
        personaDAO.update(persona);
        return persona;
    }

    @Override
    public void deleteById(int id) {
        personaDAO.delete(id);
    }
}

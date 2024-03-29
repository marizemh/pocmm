package com.venturicg.poc.service;

import com.venturicg.poc.service.model.Persona;

import java.util.List;

public interface PersonasService {

    List<Persona> findAll();

    Persona findById(String id);

    Persona save(Persona persona);

    Persona update(String id, Persona persona);

    void deleteById(String id);

    List<Persona> obtenerPersonas();

}

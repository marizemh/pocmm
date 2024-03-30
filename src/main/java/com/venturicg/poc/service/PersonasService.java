package com.venturicg.poc.service;

import com.venturicg.poc.service.model.Persona;

import java.util.List;

public interface PersonasService {
    List<Persona> findAll();

    Persona findById(int id);

    Persona save(Persona persona);

    Persona update(int id, Persona persona);

    void deleteById(int id);
}

/*
package com.venturicg.poc.web.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venturicg.poc.service.PersonasService;
import com.venturicg.poc.service.model.Persona;

@RestController
@RequestMapping("/api/personas")
public class PersonasController {
    private final PersonasService personasService;

    @Autowired
    public PersonaController(PersonasService personasService) {
        this.personasService = personasService;
    }

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personasService.getAllPersonas();
    }

    @GetMapping("/{id}")
    public Persona getPersonaById(@PathVariable int id) {
        return personasService.getPersonaById(id);
    }

    @PostMapping
    public void createPersona(@RequestBody Persona persona) {
        personasService.createPersona(persona);
    }

    @PutMapping("/{id}")
    public void updatePersona(@PathVariable int id, @RequestBody Persona persona) {
        persona.setId(id);
        personasService.updatePersona(persona);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable int id) {
        personasService.deletePersona(id);
    }
}

*/
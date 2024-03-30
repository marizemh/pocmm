package com.venturicg.poc.web.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public PersonasController(PersonasService personasService) {
        this.personasService = personasService;
    }

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personasService.findAll();
    }

    @GetMapping("/{id}")
    public Persona getPersonaById(@PathVariable int id) {
        return personasService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Persona> createPersona(@RequestBody Persona persona) {
        Persona nuevaPersona = personasService.save(persona);
        return new ResponseEntity<>(nuevaPersona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable int id, @RequestBody Persona persona) {
        Persona personaActualizada = personasService.update(id, persona);
        return new ResponseEntity<>(personaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable int id) {
        personasService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

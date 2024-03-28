package com.venturicg.poc.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.venturicg.poc.service.model.PersonaRepository;
import com.venturicg.poc.service.model.Persona;


@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Persona getPersonaById(@PathVariable Long id) {
        return personaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada con ID: " + id));
    }

    @PostMapping
    public Persona createPersona(@RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    @PutMapping("/{id}")
    public Persona updatePersona(@PathVariable Long id, @RequestBody Persona persona) {
        Persona personaToUpdate = personaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada con ID: " + id));
        personaToUpdate.setNombres(persona.getNombres());
        personaToUpdate.setApellidos(persona.getApellidos());
        personaToUpdate.setPais(persona.getPais());
        return personaRepository.save(personaToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Long id) {
        personaRepository.deleteById(id);
    }

}

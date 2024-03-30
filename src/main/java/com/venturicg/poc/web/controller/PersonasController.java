package com.venturicg.poc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.venturicg.poc.service.PersonasService;
import com.venturicg.poc.service.model.Persona;

//import antlr.collections.List;

@Controller
public class PersonasController {

    @RequestMapping("/personas")
    public String home() {
        return "personas";
    }

    private final PersonasService personasService;

    @Autowired
    public PersonasController(PersonasService personasService) {
        this.personasService = personasService;
    }

    /* 
    @GetMapping
    public List<Persona> getAllPersonas() {
        return personasService.findAll();
    }
*/
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

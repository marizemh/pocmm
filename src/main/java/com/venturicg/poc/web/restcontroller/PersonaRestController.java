package com.venturicg.poc.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.venturicg.poc.service.PersonasService;
import com.venturicg.poc.service.model.Persona;

import java.util.List;

@RestController
@RequestMapping("/rest/personas")
public class PersonaRestController {

  @Autowired
  private PersonasService personasService;

  @GetMapping("")
  public ResponseEntity<List<Persona>> obtenerPersonas() {
    return new ResponseEntity<>(personasService.findAll(), HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona) {
    Persona nuevaPersona = personasService.save(persona);
    return new ResponseEntity<>(nuevaPersona, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Persona> editarPersona(@PathVariable int id, @RequestBody Persona persona) {
    if (id != persona.getId()) {
      throw new IllegalArgumentException("ID de persona en la URL y en el body no coinciden");
    }
    Persona personaActualizada = personasService.update(id, persona);
    return new ResponseEntity<>(personaActualizada, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> eliminarPersona(@PathVariable int id) {
    personasService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}

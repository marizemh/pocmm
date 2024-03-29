package com.venturicg.poc.web.restcontroller;

import com.venturicg.poc.service.PersonasService;
import com.venturicg.poc.service.model.Persona;
import com.venturicg.poc.web.dto.PersonaDTO;
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

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/personas")
public class PersonaRestController {

  @Autowired
  private PersonasService personasService;

  @GetMapping("")
  public ResponseEntity<List<PersonaDTO>> obtenerPersonas() {
    return new ResponseEntity<>(personasService.obtenerPersonas().stream()
      .map(persona -> new PersonaDTO(persona.getId(), persona.getNombres(), persona.getApellidos(), persona.getPais()))
      .collect(Collectors.toList()), HttpStatus.OK);
  }

  // Nuevos endpoints para crear, editar y eliminar personas
  @PostMapping("")
  public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona) {
    Persona nuevaPersona = personasService.save(persona);
    return new ResponseEntity<>(nuevaPersona, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Persona> editarPersona(@PathVariable String id, @RequestBody Persona persona) {
    if (!id.equals(persona.getId())) {
      throw new IllegalArgumentException("ID de persona en la URL y en el body no coinciden");
    }
    Persona personaActualizada = personasService.update(id, persona);
    return new ResponseEntity<>(personaActualizada, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> eliminarPersona(@PathVariable String id) {
    personasService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}

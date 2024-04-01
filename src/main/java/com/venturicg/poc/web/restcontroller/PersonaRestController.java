package com.venturicg.poc.web.restcontroller;

import com.venturicg.poc.service.PersonasService;
import com.venturicg.poc.service.model.Persona;
import com.venturicg.poc.web.dto.PersonaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/personas")
public class PersonaRestController {

    private final PersonasService personasService;

    @Autowired
    public PersonaRestController(PersonasService personasService) {
        this.personasService = personasService;
    }

    @GetMapping("")
    public ResponseEntity<List<PersonaDTO>> obtenerPersonas() {
        List<PersonaDTO> personasDTO = personasService.findAll().stream()
                .map(persona -> new PersonaDTO(persona.getId(), persona.getNombres(), persona.getApellidos(), persona.getPais()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(personasDTO);
    }

    @PostMapping("")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona) {
        Persona nuevaPersona = personasService.save(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPersona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> editarPersona(@PathVariable int id, @RequestBody Persona persona) {
        if (id != persona.getId()) {
            throw new IllegalArgumentException("ID de persona en la URL y en el body no coinciden");
        }
        Persona personaActualizada = personasService.update(id, persona);
        return ResponseEntity.ok(personaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable int id) {
        personasService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

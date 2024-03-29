package com.venturicg.poc.repository;

import com.venturicg.poc.service.model.Persona;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonaDAO {

    @Select("select * from persona")
    List<Persona> obtenerPersonas();

    List<Persona> findAll();

    Persona findById(String id);

    Persona save(Persona persona);

    boolean existsById(String id);

    void deleteById(String id);
}

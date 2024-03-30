package com.venturicg.poc.repository;

import com.venturicg.poc.service.model.Persona;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PersonaDAO {
    @Select("SELECT * FROM persona")
    List<Persona> findAll();

    @Select("SELECT * FROM persona WHERE id = #{id}")
    Persona findById(int id);

    @Insert("INSERT INTO persona(nombres, apellidos, pais) VALUES(#{nombres}, #{apellidos}, #{pais})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Persona persona);

    @Update("UPDATE persona SET nombres = #{nombres}, apellidos = #{apellidos}, pais = #{pais} WHERE id = #{id}")
    void update(Persona persona);

    @Delete("DELETE FROM persona WHERE id = #{id}")
    void delete(int id);
}
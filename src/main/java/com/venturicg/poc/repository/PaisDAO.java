package com.venturicg.poc.repository;

import com.venturicg.poc.service.model.Pais;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PaisDAO {

    @Select("select * from pais")
    List<Pais> obtenerPaises();
}

package com.venturicg.poc.service.impl;

import com.venturicg.poc.repository.PaisDAO;
import com.venturicg.poc.service.PaisesService;
import com.venturicg.poc.service.model.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServiceImpl implements PaisesService {

    @Autowired
    private PaisDAO paisDAO;


    @Override
    public List<Pais> obtenerPaises() {
        return paisDAO.obtenerPaises();
    }
}

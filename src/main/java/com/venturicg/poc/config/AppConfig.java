package com.venturicg.poc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.venturicg.poc.service.PersonasService;
import com.venturicg.poc.service.impl.PersonaServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public PersonasService personasService() {
        return new PersonaServiceImpl();
    }
}

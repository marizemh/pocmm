package com.venturicg.poc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonaViewController {
    @GetMapping("/personas")
    public String personasView(Model model) {
        return "personas";
    }
}
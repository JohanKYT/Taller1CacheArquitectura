package com.example.restservice;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class TimeController {

    @Cacheable("hora")
    @GetMapping("/hora")
    public String getHora() {
        System.out.println("Obteniendo hora real (sin cache todavía)...");
        return "La hora actual es: " + LocalDateTime.now();
    }
}


package com.example.restservice;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class MessageController {

    private final String[] messages = {
            "¡Hola Soy Johan Y Esta Es Una Prueba!",
            "Bienvenido al servicio de cache",
            "Udla gente que ama lo que hace",
            "Unas dos que tres?"
    };

    @Cacheable("mensaje") // caché
    @GetMapping("/mensaje")
    public String getMessage() {
        System.out.println("Generando mensaje nuevo");
        int index = new Random().nextInt(messages.length);
        return messages[index];
    }
}


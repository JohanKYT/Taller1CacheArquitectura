package com.example.restservice;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    private String cachedMessage = null; // caché interna
    private final Random random = new Random();
    
    @GetMapping("/mensaje")

    public String getMessage() {
        if (cachedMessage != null) {
            System.out.println("Usando mensaje en caché (proxy)");
            return cachedMessage;
        }
        System.out.println("Generando mensaje nuevo (proxy)");
        cachedMessage = messages[random.nextInt(messages.length)];
        return cachedMessage;
    }
    @PostMapping("/clear-cache")
    public String clearCache() {
        cachedMessage = null;
        return "Cache de /mensaje limpiado!";
    }
}


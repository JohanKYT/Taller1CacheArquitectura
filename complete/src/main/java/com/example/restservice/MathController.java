package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @GetMapping("/sumar")
    public String sumar(@RequestParam int a, @RequestParam int b) {
        int resultado = a + b;
        return "La suma de " + a + " + " + b + " = " + resultado;
    }
}


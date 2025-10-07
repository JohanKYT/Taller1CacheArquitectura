package com.example.restservice;

import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

    private final CacheManager cacheManager;

    public CacheController(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @PostMapping("/clear-cache")
    public String clearCache() {
        cacheManager.getCache("mensaje").clear();
        return "Cache de /mensaje limpiado!";
    }
}

package com.printshop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/config")
public class ConfigController {

    @Value("${api.base.url}")
    private String apiBaseUrl;

    @GetMapping("/base-url")
    public ResponseEntity<String> getApiBaseUrl() {
        return ResponseEntity.ok(apiBaseUrl);
    }
}
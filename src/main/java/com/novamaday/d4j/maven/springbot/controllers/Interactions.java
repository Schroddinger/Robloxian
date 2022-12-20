package com.novamaday.d4j.maven.springbot.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/interactions")
@CrossOrigin
public class Interactions {

    @GetMapping(value = "/test")
    public String test(){
        return "This function works";
    }
}

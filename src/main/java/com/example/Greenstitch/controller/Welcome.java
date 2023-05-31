package com.example.Greenstitch.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class Welcome {
    @GetMapping("hello")
    public ResponseEntity<?> hiUser(){


        return  ResponseEntity.ok().body("Your Jwt is perfect");
    }
}

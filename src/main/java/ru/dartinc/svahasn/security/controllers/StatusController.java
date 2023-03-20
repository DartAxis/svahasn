package ru.dartinc.svahasn.security.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class StatusController {
    @GetMapping
    public ResponseEntity<String> getStatus(){
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}

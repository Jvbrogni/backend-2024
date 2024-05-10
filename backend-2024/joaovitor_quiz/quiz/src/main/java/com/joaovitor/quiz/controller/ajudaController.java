package com.joaovitor.quiz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ajudaController {

    @GetMapping("/ajuda")
    public ResponseEntity<Map<String, String>> hello() {
        Map<String, String> response = new HashMap<>();
        response.put("estudante", "João");
        response.put("projeto", "Quiz");
        return ResponseEntity.ok(response);
    }
}
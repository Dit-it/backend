package com.example.backend.controller;

import com.example.backend.service.TypesOfLitterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/litter")
@RequiredArgsConstructor
@Slf4j
public class TypesOfLitterController {

    private final TypesOfLitterService typesOfLitterService;

    @GetMapping
    public ResponseEntity<?> getTypesOfLitter() {
        log.info("/api/v1/litter : GET");
        return ResponseEntity.ok(typesOfLitterService.getTypesOfLitter());
    }
}

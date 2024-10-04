package com.example.backend.controller;

import com.example.backend.service.SigunguInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/sigunguInfo")
public class SigunguInfoController {

    private final SigunguInfoService sigunguInfoService;

    @GetMapping
    public ResponseEntity<?> getSigunguList(){
        return ResponseEntity.ok().body(sigunguInfoService.findAll());
    }
}

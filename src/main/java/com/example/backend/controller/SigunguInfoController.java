package com.example.backend.controller;

import com.example.backend.dto.SigunguInfoResponseDto;
import com.example.backend.entity.SigunguInfo;
import com.example.backend.service.SigunguInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/sigunguInfo")
@CrossOrigin(origins = "*")
public class SigunguInfoController {

    private final SigunguInfoService sigunguInfoService;

    @GetMapping
    public ResponseEntity<?> getSigunguList(){
        log.info("/api/v1/sigunguInfo - GET !!");
        List<SigunguInfoResponseDto> simple = sigunguInfoService.findSimple();
        return ResponseEntity.ok().body(simple);
    }
}

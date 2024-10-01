package com.example.backend.controller;

import com.example.backend.service.CoastManageInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/coast")
@RequiredArgsConstructor
@Slf4j
public class CoastManageInfoController {

    private final CoastManageInfoService coastManageInfoService;

    @GetMapping("/list")
    public ResponseEntity<?> getCoastManageInfoService() {
        return ResponseEntity.ok().body(coastManageInfoService.getCoastManageInfoList());
    }

}

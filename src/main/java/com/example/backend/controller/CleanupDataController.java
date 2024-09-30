package com.example.backend.controller;

import com.example.backend.dto.CleanupDataGroupBySigunguRequestDto;
import com.example.backend.dto.CleanupDataGroupBySigunguResponseDto;
import com.example.backend.entity.CleanupData;
import com.example.backend.service.CleanupDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cleanup")
@RequiredArgsConstructor
@Slf4j
public class CleanupDataController {

    private final CleanupDataService cleanupDataService;

    @GetMapping("/cleanupDataGroupBySigungu/{startDate}/{endDate}")
    public ResponseEntity<?> cleanupDataGroupBySigungu(
            @PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate startDate
            , @PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate endDate
    ){

        List<CleanupDataGroupBySigunguResponseDto> cleanupData = cleanupDataService.cleanupDataGroupBySigungu(new CleanupDataGroupBySigunguRequestDto(startDate, endDate));
        return ResponseEntity.ok().body(cleanupData);
    }


}

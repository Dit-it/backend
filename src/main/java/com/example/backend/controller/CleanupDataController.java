package com.example.backend.controller;

import com.example.backend.dto.*;
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
        log.info("/api/v1/cleanup/cleanupDataGroupBySigungu/{}/{} - GET !!", startDate, endDate);

        List<CleanupDataGroupByCoastResponseDto> cleanupData = cleanupDataService.cleanupDataGroupBySigungu(startDate, endDate);
        System.out.println("cleanupData = " + cleanupData);
        return ResponseEntity.ok().body(cleanupData);
    }

    @GetMapping("/totalCollectedLitterByCoast/{startDate}/{endDate}")
    public ResponseEntity<?> totalCollectedLitterByCoast(
            @PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate startDate
            , @PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate endDate
    ){
        log.info("/api/v1/cleanup/totalCollectedLitterByCoast/{}/{} - GET !!", startDate, endDate);

        List<TotalCleanupLitterGroupBySigunguResponseDto> cleanupData = cleanupDataService.totalCollectedLitterByCoast(new CleanupStatsDataRequestDto(startDate, endDate));
        System.out.println("cleanupData = " + cleanupData);
        return ResponseEntity.ok().body(cleanupData);
    }

    @GetMapping("/MajorTypeOfLitterGroupByCoast/{startDate}/{endDate}")
    public ResponseEntity<?> MajorTypeOfLitterGroupByCoast(
            @PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate startDate
            , @PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate endDate
    ){
        log.info("/api/v1/cleanup/MajorTypeOfLitterGroupByCoast/{}/{} - GET !!", startDate, endDate);

        List<MajorTypeOfLitterGroupByCoastResponseDto> cleanupData = cleanupDataService.MajorTypeOfLitterGroupByCoast(new CleanupStatsDataRequestDto(startDate, endDate));
        System.out.println("cleanupData = " + cleanupData);
        return ResponseEntity.ok().body(cleanupData);
    }

    @GetMapping("/MajorTypeOfLitterGroupBySigungu/{startDate}/{endDate}")
    public ResponseEntity<?> MajorTypeOfLitterGroupBySigungu(
            @PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate startDate
            , @PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate endDate
    ){
        log.info("/api/v1/cleanup/MajorTypeOfLitterGroupBySigungu/{}/{} - GET !!", startDate, endDate);

        List<MajorTypeOfLitterGroupByCoastResponseDto> cleanupData = cleanupDataService.MajorTypeOfLitterGroupBySigungu(startDate, endDate);
        System.out.println("cleanupData = " + cleanupData);
        return ResponseEntity.ok().body(cleanupData);
    }

    /**
     * @param dto requestDTO
     * @return save result
     */
    @PostMapping("")
    public ResponseEntity<?> saveCleanupData(SaveCleanupDataRequestDTO dto) {
//      TODO: get userId from jwt after login finished
        boolean result = cleanupDataService.saveCleanupData(dto, "user01");
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/collect/{cleanupDataId}")
    public ResponseEntity<?> collectCleanup(@PathVariable(name = "cleanupDataId") int cleanupDataId) {
//      TODO: get userId from jwt after login finished
        boolean result = cleanupDataService.collectCleanup(cleanupDataId, "user06");
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/uncollected")
    public ResponseEntity<?> getAllUncollectedCleanupData() {
        List<UncollectedCleanupDataResponseDTO> uncollectedCleanupDataResponseDTOList = cleanupDataService.getAllUncollectedCleanupData();
        return ResponseEntity.ok().body(uncollectedCleanupDataResponseDTOList);
    }

}

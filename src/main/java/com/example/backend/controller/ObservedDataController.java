package com.example.backend.controller;

import com.example.backend.dto.ObservedMajorTypeOfLitterGroupByCoastResponseDTO;
import com.example.backend.dto.RegisterObservedDataRequestDTO;
import com.example.backend.service.ObservedDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/observe")
public class ObservedDataController {

    private final ObservedDataService observedDataService;

    @PostMapping("/register")
    public ResponseEntity<?> registerObservedData(
            @RequestPart("observedPicture") MultipartFile observedPicture,
            @RequestPart("regData") RegisterObservedDataRequestDTO dto) throws IOException {

        log.info("/api/v1/observe/register - POST !!");

        // TODO: get userId from jwt after login finished
        String userId = "user01";

        RegisterObservedDataRequestDTO newData = new RegisterObservedDataRequestDTO(userId, dto, observedPicture);

        if (observedDataService.regObservedData(newData) == null) {
            return ResponseEntity.badRequest().body("fail-observed-register");
        }

        return ResponseEntity.ok().body("success-observed-register");
    }

    @GetMapping("/majorLitterByCoast/{startDate}/{endDate}")
    public ResponseEntity<?> searchObservedMajorLitterByCoast(
            @PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate startDate
            , @PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate endDate
    ) {

        log.info("/api/v1/observe/majorLitterByCoast/{}/{} - Get !!", startDate, endDate);

        List<ObservedMajorTypeOfLitterGroupByCoastResponseDTO> responseDTOList =
                observedDataService.searchObservedMajorLitterByCoast(startDate, endDate);

        return ResponseEntity.ok().body(responseDTOList);
    }
}

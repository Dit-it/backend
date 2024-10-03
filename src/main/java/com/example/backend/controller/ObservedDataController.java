package com.example.backend.controller;

import com.example.backend.dto.RegisterObservedDataRequestDTO;
import com.example.backend.service.ObservedDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

        String resultMsg = "false";
        String userId = "user01"; // jwt에서 userId 추출 예정

        RegisterObservedDataRequestDTO newData = new RegisterObservedDataRequestDTO(userId, dto, observedPicture);

        if (observedDataService.regObservedData(newData) != null) {
            resultMsg = "success";
        }

        return ResponseEntity.ok().body(resultMsg);
    }
}

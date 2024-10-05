package com.example.backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString @EqualsAndHashCode
@NoArgsConstructor
public class SaveCleanupDataRequestDTO {
    private String observedDataId;
    private MultipartFile beforeCleanupPicture;
    private MultipartFile afterCleanupPicture;
    private LocalDateTime cleanupDt;
    private int count50liter;
    private double lon;
    private double lat;
    private MultipartFile collectionPicture;
    private String litterTypeCode;
    private String collectionLocationMemo;

    public void setCleanupDt(String cleanupDt) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        this.cleanupDt = LocalDateTime.parse(cleanupDt, dateTimeFormatter);
    }
}

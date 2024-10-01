package com.example.backend.dto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CleanupStatsDataRequestDto {

    private LocalDate startDate;
    private LocalDate endDate;
}

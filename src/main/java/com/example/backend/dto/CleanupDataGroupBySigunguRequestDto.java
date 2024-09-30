package com.example.backend.dto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CleanupDataGroupBySigunguRequestDto {

    private LocalDate startDate;
    private LocalDate endDate;
}

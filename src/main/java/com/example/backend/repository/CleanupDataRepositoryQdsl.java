package com.example.backend.repository;


import com.example.backend.dto.CleanupStatsDataRequestDto;
import com.example.backend.dto.CleanupDataGroupBySigunguResponseDto;

import java.util.List;

public interface CleanupDataRepositoryQdsl {
    List<CleanupDataGroupBySigunguResponseDto> cleanupDataGroupBySigungu(CleanupStatsDataRequestDto cleanupStatsDataRequestDto);
}

package com.example.backend.repository;


import com.example.backend.dto.CleanupStatsDataRequestDto;
import com.example.backend.dto.CleanupDataGroupByCoastResponseDto;
import com.example.backend.dto.MajorTypeOfLitterGroupByCoastResponseDto;

import java.util.List;

public interface CleanupDataRepositoryQdsl {
    List<CleanupDataGroupByCoastResponseDto> cleanupDataGroupBySigungu(CleanupStatsDataRequestDto cleanupStatsDataRequestDto);

    List<MajorTypeOfLitterGroupByCoastResponseDto> MajorTypeOfLitterGroupByCoast(CleanupStatsDataRequestDto cleanupStatsDataRequestDto);
}

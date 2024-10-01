package com.example.backend.service;

import com.example.backend.dto.CleanupStatsDataRequestDto;
import com.example.backend.dto.CleanupDataGroupByCoastResponseDto;
import com.example.backend.dto.MajorTypeOfLitterGroupByCoastResponseDto;
import com.example.backend.dto.TotalCleanupLitterGroupBySigunguResponseDto;

import java.util.List;

public interface CleanupDataService {


    List<CleanupDataGroupByCoastResponseDto> cleanupDataGroupBySigungu(CleanupStatsDataRequestDto cleanupStatsDataRequestDto);

    List<TotalCleanupLitterGroupBySigunguResponseDto> totalCollectedLitterByCoast(CleanupStatsDataRequestDto cleanupStatsDataRequestDto);

    List<MajorTypeOfLitterGroupByCoastResponseDto> MajorTypeOfLitterGroupByCoast(CleanupStatsDataRequestDto cleanupStatsDataRequestDto);
}

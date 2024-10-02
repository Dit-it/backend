package com.example.backend.service;

import com.example.backend.dto.*;

import java.util.List;

public interface CleanupDataService {


    List<CleanupDataGroupByCoastResponseDto> cleanupDataGroupBySigungu(CleanupStatsDataRequestDto cleanupStatsDataRequestDto);

    List<TotalCleanupLitterGroupBySigunguResponseDto> totalCollectedLitterByCoast(CleanupStatsDataRequestDto cleanupStatsDataRequestDto);

    boolean saveCleanupData(SaveCleanupDataRequestDTO dto, String memberId);

    List<MajorTypeOfLitterGroupByCoastResponseDto> MajorTypeOfLitterGroupByCoast(CleanupStatsDataRequestDto cleanupStatsDataRequestDto);
}

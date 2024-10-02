package com.example.backend.service;

import com.example.backend.dto.CleanupStatsDataRequestDto;
import com.example.backend.dto.CleanupDataGroupBySigunguResponseDto;
import com.example.backend.dto.SaveCleanupDataRequestDTO;
import com.example.backend.dto.TotalCleanupLitterGroupBySigunguResponseDto;

import java.util.List;
import java.util.NoSuchElementException;

public interface CleanupDataService {


    List<CleanupDataGroupBySigunguResponseDto> cleanupDataGroupBySigungu(CleanupStatsDataRequestDto cleanupStatsDataRequestDto);

    List<TotalCleanupLitterGroupBySigunguResponseDto> totalCollectedLitterByCoast(CleanupStatsDataRequestDto cleanupStatsDataRequestDto);

    boolean saveCleanupData(SaveCleanupDataRequestDTO dto, String memberId);
}

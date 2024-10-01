package com.example.backend.service;

import com.example.backend.dto.CleanupStatsDataRequestDto;
import com.example.backend.dto.CleanupDataGroupByCoastResponseDto;
import com.example.backend.dto.MajorTypeOfLitterGroupByCoastResponseDto;
import com.example.backend.dto.TotalCleanupLitterGroupBySigunguResponseDto;
import com.example.backend.repository.CleanupDataRepository;
import com.example.backend.repository.CleanupDataRepositoryQdsl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CleanupDataServiceImpl implements CleanupDataService {

    private final CleanupDataRepositoryQdsl cleanupDataRepositoryQdsl;
    private final CleanupDataRepository cleanupDataRepository;

    @Override
    public List<CleanupDataGroupByCoastResponseDto> cleanupDataGroupBySigungu(CleanupStatsDataRequestDto cleanupStatsDataRequestDto) {
        return cleanupDataRepositoryQdsl.cleanupDataGroupBySigungu(cleanupStatsDataRequestDto);
    }

    @Override
    public List<TotalCleanupLitterGroupBySigunguResponseDto> totalCollectedLitterByCoast(CleanupStatsDataRequestDto cleanupStatsDataRequestDto) {
        List<TotalCleanupLitterGroupBySigunguResponseDto> totalCleanupLitterGroupBySigunguResponseDtos =
                cleanupDataRepository.totalCollectedLitterByCoast(
                        cleanupStatsDataRequestDto.getStartDate()
                        , cleanupStatsDataRequestDto.getEndDate())
                        .stream().map(TotalCleanupLitterGroupBySigunguResponseDto::new).toList();
        System.out.println("totalCleanupLitterGroupBySigunguResponseDtos = " + totalCleanupLitterGroupBySigunguResponseDtos);
        return totalCleanupLitterGroupBySigunguResponseDtos;
    }

    @Override
    public List<MajorTypeOfLitterGroupByCoastResponseDto> MajorTypeOfLitterGroupByCoast(CleanupStatsDataRequestDto cleanupStatsDataRequestDto) {
        return cleanupDataRepositoryQdsl.MajorTypeOfLitterGroupByCoast(cleanupStatsDataRequestDto);
    }
}

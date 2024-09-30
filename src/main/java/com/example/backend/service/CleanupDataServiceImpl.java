package com.example.backend.service;

import com.example.backend.dto.CleanupDataGroupBySigunguRequestDto;
import com.example.backend.dto.CleanupDataGroupBySigunguResponseDto;
import com.example.backend.repository.CleanupDataRepositoryQdsl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CleanupDataServiceImpl implements CleanupDataService {

    private final CleanupDataRepositoryQdsl cleanupDataRepositoryQdsl;

    @Override
    public List<CleanupDataGroupBySigunguResponseDto> cleanupDataGroupBySigungu(CleanupDataGroupBySigunguRequestDto cleanupDataGroupBySigunguRequestDto) {
        return cleanupDataRepositoryQdsl.cleanupDataGroupBySigungu(cleanupDataGroupBySigunguRequestDto);
    }
}

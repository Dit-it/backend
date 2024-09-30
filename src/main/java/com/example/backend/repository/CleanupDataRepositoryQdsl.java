package com.example.backend.repository;


import com.example.backend.dto.CleanupDataGroupBySigunguRequestDto;
import com.example.backend.dto.CleanupDataGroupBySigunguResponseDto;
import com.example.backend.entity.CleanupData;

import java.util.List;

public interface CleanupDataRepositoryQdsl {
    List<CleanupDataGroupBySigunguResponseDto> cleanupDataGroupBySigungu(CleanupDataGroupBySigunguRequestDto cleanupDataGroupBySigunguRequestDto);
}

package com.example.backend.service;

import com.example.backend.dto.CleanupDataGroupBySigunguRequestDto;
import com.example.backend.dto.CleanupDataGroupBySigunguResponseDto;
import java.util.List;

public interface CleanupDataService {


    List<CleanupDataGroupBySigunguResponseDto> cleanupDataGroupBySigungu(CleanupDataGroupBySigunguRequestDto cleanupDataGroupBySigunguRequestDto);
}

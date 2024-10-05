package com.example.backend.service;

import com.example.backend.dto.SigunguInfoResponseDto;
import com.example.backend.entity.SigunguInfo;

import java.util.List;

public interface SigunguInfoService {

    List<SigunguInfoResponseDto> findSimple();
}

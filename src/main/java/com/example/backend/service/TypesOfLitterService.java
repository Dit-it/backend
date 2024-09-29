package com.example.backend.service;

import com.example.backend.dto.GetTypesOfLitterResponseDTO;

import java.util.List;

public interface TypesOfLitterService {
     List<GetTypesOfLitterResponseDTO> getTypesOfLitter();
}

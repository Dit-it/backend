package com.example.backend.service;

import com.example.backend.dto.ObservedEstimationLitterGroupByCoastResponseDTO;
import com.example.backend.dto.ObservedMajorTypeOfLitterGroupByCoastResponseDTO;
import com.example.backend.dto.RegisterObservedDataRequestDTO;
import com.example.backend.entity.ObservedData;

import java.time.LocalDate;
import java.util.List;


public interface ObservedDataService {
    ObservedData regObservedData(RegisterObservedDataRequestDTO regData);
    List<ObservedMajorTypeOfLitterGroupByCoastResponseDTO> searchObservedMajorLitterByCoast(LocalDate startDate, LocalDate endDate);
    List<ObservedEstimationLitterGroupByCoastResponseDTO> searchObservedEstimationLitterByCoast(LocalDate startDate, LocalDate endDate);
}

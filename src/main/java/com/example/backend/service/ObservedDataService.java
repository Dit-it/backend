package com.example.backend.service;

import com.example.backend.dto.RegisterObservedDataRequestDTO;
import com.example.backend.entity.ObservedData;


public interface ObservedDataService {
    ObservedData regObservedData(RegisterObservedDataRequestDTO regData);
}

package com.example.backend.service;

import com.example.backend.dto.GetCoastMangeInfoResponseDTO;

import java.util.List;

public interface CoastManageInfoService {
    List<GetCoastMangeInfoResponseDTO> getCoastManageInfoList();
    List<GetCoastMangeInfoResponseDTO> getCoastManageInfoListBySigungu(String sigunguId);

}

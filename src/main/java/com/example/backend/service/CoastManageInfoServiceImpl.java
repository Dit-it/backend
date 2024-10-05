package com.example.backend.service;

import com.example.backend.dto.GetCoastMangeInfoResponseDTO;
import com.example.backend.repository.CoastManageInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoastManageInfoServiceImpl implements CoastManageInfoService{

    private final CoastManageInfoRepository coastManageInfoRepository;

    @Override
    public List<GetCoastMangeInfoResponseDTO> getCoastManageInfoList() {
        return coastManageInfoRepository.findAllCoastInfo().stream()
                .map(GetCoastMangeInfoResponseDTO::new).toList();
    }

    @Override
    public List<GetCoastMangeInfoResponseDTO> getCoastManageInfoListBySigungu(String sigunguCode) {
        return coastManageInfoRepository.findAllBySigunguCode(sigunguCode)
                .stream().map(GetCoastMangeInfoResponseDTO::new).toList();
    }
}

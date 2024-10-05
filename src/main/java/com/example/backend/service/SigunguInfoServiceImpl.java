package com.example.backend.service;

import com.example.backend.dto.SigunguInfoResponseDto;
import com.example.backend.entity.SigunguInfo;
import com.example.backend.repository.SigunguRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class SigunguInfoServiceImpl implements SigunguInfoService {

    private final SigunguRepository sigunguRepository;

    @Override
    public List<SigunguInfoResponseDto> findSimple() {
        return sigunguRepository.findSimple().stream().map(
                SigunguInfoResponseDto::new
        ).collect(Collectors.toList());
    }
}

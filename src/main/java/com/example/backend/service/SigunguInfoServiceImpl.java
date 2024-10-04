package com.example.backend.service;

import com.example.backend.entity.SigunguInfo;
import com.example.backend.repository.SigunguRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SigunguInfoServiceImpl implements SigunguInfoService {

    private final SigunguRepository sigunguRepository;

    @Override
    public List<SigunguInfo> findAll() {
        return sigunguRepository.findAll();
    }
}

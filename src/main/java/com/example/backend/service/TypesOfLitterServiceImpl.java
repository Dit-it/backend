package com.example.backend.service;

import com.example.backend.dto.GetTypesOfLitterResponseDTO;
import com.example.backend.repository.TypesOfLitterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypesOfLitterServiceImpl implements TypesOfLitterService {

    private final TypesOfLitterRepository typesOfLitterRepository;

    @Override
    public List<GetTypesOfLitterResponseDTO> getTypesOfLitter() {
        return typesOfLitterRepository.findAllByOrderByLitterTypeCode().stream()
                .map(GetTypesOfLitterResponseDTO::new).toList();
    }
}

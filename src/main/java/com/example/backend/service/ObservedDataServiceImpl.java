package com.example.backend.service;

import com.example.backend.dto.ObservedEstimationLitterGroupByCoastResponseDTO;
import com.example.backend.dto.ObservedMajorTypeOfLitterGroupByCoastResponseDTO;
import com.example.backend.dto.ObservedMajorTypeOfLitterGroupByCoastResponseInterface;
import com.example.backend.dto.RegisterObservedDataRequestDTO;
import com.example.backend.entity.CoastManageInfo;
import com.example.backend.entity.MemberInfo;
import com.example.backend.entity.ObservedData;
import com.example.backend.entity.TypesOfLitter;
import com.example.backend.handler.ImageHandler;
import com.example.backend.repository.CoastManageInfoRepository;
import com.example.backend.repository.MemberInfoRepository;
import com.example.backend.repository.ObservedDataRepository;
import com.example.backend.repository.TypesOfLitterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ObservedDataServiceImpl implements ObservedDataService {

    private final ObservedDataRepository observedDataRepository;
    private final MemberInfoRepository memberInfoRepository;
    private final CoastManageInfoRepository coastManageInfoRepository;
    private final TypesOfLitterRepository typesOfLitterRepository;
    private final ImageHandler imageHandler;

    @Override
    public ObservedData regObservedData(RegisterObservedDataRequestDTO dto) {

        MemberInfo memberInfo = memberInfoRepository.findById(dto.getMemberId())
                .orElseThrow(RuntimeException::new);

        CoastManageInfo coastManageInfo = coastManageInfoRepository.findById(dto.getCoastCode())
                .orElseThrow(RuntimeException::new);

        TypesOfLitter typesOfLitter = typesOfLitterRepository.findById(dto.getLitterTypeCode())
                .orElseThrow(RuntimeException::new);

        ObservedData regData = null;

        try {
            regData = ObservedData.builder()
                    .observedDataId(dto.getObservedDataId())
                    .memberId(memberInfo)
                    .coastCode(coastManageInfo)
                    .estimationLiter(dto.getEstimationLiter())
                    .observedPicture(imageHandler.saveImage(dto.getObservedPicture()))
                    .observedDt(dto.getObservedDt())
                    .observedMajorLitter(typesOfLitter)
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return observedDataRepository.save(regData);
    }

    @Override
    public List<ObservedMajorTypeOfLitterGroupByCoastResponseDTO> searchObservedMajorLitterByCoast(LocalDate startDate, LocalDate endDate) {

        List<ObservedMajorTypeOfLitterGroupByCoastResponseDTO> dtoList =
                observedDataRepository.searchObservedMajorLitterByCoast(startDate, endDate)
                .stream().map(ObservedMajorTypeOfLitterGroupByCoastResponseDTO::new)
                .toList();

        return dtoList;
    }

    @Override
    public List<ObservedEstimationLitterGroupByCoastResponseDTO> searchObservedEstimationLitterByCoast(LocalDate startDate, LocalDate endDate) {

        List<ObservedEstimationLitterGroupByCoastResponseDTO> dtoList =
                observedDataRepository.searchObservedEstimationLitterByCoast(startDate, endDate)
                        .stream().map(ObservedEstimationLitterGroupByCoastResponseDTO::new)
                        .toList();

        return dtoList;
    }
}

package com.example.backend.service;

import com.example.backend.dto.*;
import com.example.backend.entity.CleanupData;
import com.example.backend.entity.MemberInfo;
import com.example.backend.entity.ObservedData;
import com.example.backend.entity.TypesOfLitter;
import com.example.backend.handler.ImageHandler;
import com.example.backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CleanupDataServiceImpl implements CleanupDataService {

    private final CleanupDataRepositoryQdsl cleanupDataRepositoryQdsl;
    private final CleanupDataRepository cleanupDataRepository;
    private final ObservedDataRepository observedDataRepository;
    private final MemberInfoRepository memberInfoRepository;
    private final TypesOfLitterRepository typesOfLitterRepository;
    private final ImageHandler imageHandler;

    @Override
    public List<CleanupDataGroupByCoastResponseDto> cleanupDataGroupBySigungu(CleanupStatsDataRequestDto cleanupStatsDataRequestDto) {
        return cleanupDataRepositoryQdsl.cleanupDataGroupBySigungu(cleanupStatsDataRequestDto);
    }

    @Override
    public List<TotalCleanupLitterGroupBySigunguResponseDto> totalCollectedLitterByCoast(CleanupStatsDataRequestDto cleanupStatsDataRequestDto) {
        List<TotalCleanupLitterGroupBySigunguResponseDto> totalCleanupLitterGroupBySigunguResponseDtos =
                cleanupDataRepository.totalCollectedLitterByCoast(
                                cleanupStatsDataRequestDto.getStartDate()
                                , cleanupStatsDataRequestDto.getEndDate())
                        .stream().map(TotalCleanupLitterGroupBySigunguResponseDto::new).toList();
        System.out.println("totalCleanupLitterGroupBySigunguResponseDtos = " + totalCleanupLitterGroupBySigunguResponseDtos);
        return totalCleanupLitterGroupBySigunguResponseDtos;
    }

    @Override
    public List<MajorTypeOfLitterGroupByCoastResponseDto> MajorTypeOfLitterGroupByCoast(CleanupStatsDataRequestDto cleanupStatsDataRequestDto) {
        return cleanupDataRepositoryQdsl.MajorTypeOfLitterGroupByCoast(cleanupStatsDataRequestDto);
    }

    @Override
    public boolean saveCleanupData(SaveCleanupDataRequestDTO dto, String memberId) {
        try {
            ObservedData observedData = observedDataRepository.findById(dto.getObservedDataId())
                    .orElseThrow(NoSuchElementException::new);
            MemberInfo memberInfo = memberInfoRepository.findById(memberId).orElseThrow(NoSuchElementException::new);
            // save pictures
            String beforeCleanupPicture = imageHandler.saveImage(dto.getBeforeCleanupPicture());
            String afterCleanupPicture = imageHandler.saveImage(dto.getAfterCleanupPicture());
            String collectionPicture = imageHandler.saveImage(dto.getCollectionPicture());
            GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
            TypesOfLitter typesOfLitter = typesOfLitterRepository.findById(dto.getLitterTypeCode())
                    .orElseThrow(NoSuchElementException::new);
            CleanupData cleanupData = CleanupData.builder()
                    .memberId(memberInfo)
                    .observedDataId(observedData)
                    .beforeCleanupPicture(beforeCleanupPicture)
                    .afterCleanupPicture(afterCleanupPicture)
                    .cleanupDt(dto.getCleanupDt())
                    .count50liter(dto.getCount50liter())
                    .collectionLonlat(geometryFactory.createPoint(new Coordinate(dto.getLon(), dto.getLat())))
                    .collectionPicture(collectionPicture)
                    .cleanupMajorLitter(typesOfLitter)
                    .collectionLocationMemo(dto.getCollectionLocationMemo())
                    .build();
            cleanupDataRepository.save(cleanupData);
            return true;
        } catch (NoSuchElementException | IOException e) {
            return false;
        }
    }

    @Override
    public boolean collectCleanup(Integer cleanupDataId, String driverMemberId) {
        try {
            CleanupData cleanupData = cleanupDataRepository.findById(cleanupDataId).orElseThrow(NoSuchElementException::new);
            cleanupData.setCollectionStatus(true);
            MemberInfo driverMemberInfo = memberInfoRepository.findById(driverMemberId).orElseThrow(NoSuchElementException::new);
            cleanupData.setDriverMemberId(driverMemberInfo);
            cleanupDataRepository.save(cleanupData);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public List<UncollectedCleanupDataResponseDTO> getAllUncollectedCleanupData() {
        List<CleanupData> cleanupDataList = cleanupDataRepository.findAllByCollectionStatusFalse();
        return cleanupDataList.stream().map(UncollectedCleanupDataResponseDTO::new).toList();
    }
}

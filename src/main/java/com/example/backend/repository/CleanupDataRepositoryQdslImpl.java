package com.example.backend.repository;

import com.example.backend.dto.CleanupStatsDataRequestDto;

import com.example.backend.dto.CleanupDataGroupByCoastResponseDto;
import static com.example.backend.entity.QCleanupData.cleanupData;
import static com.example.backend.entity.QCoastManageInfo.coastManageInfo;
import static com.example.backend.entity.QObservedData.observedData;
import static com.example.backend.entity.QSigunguInfo.sigunguInfo;
import static com.example.backend.entity.QTypesOfLitter.typesOfLitter;

import com.example.backend.dto.MajorTypeOfLitterGroupByCoastResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.DateTemplate;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CleanupDataRepositoryQdslImpl implements CleanupDataRepositoryQdsl {

    private final JPAQueryFactory jpaQueryFactory;
    DateTemplate<Date> cleanupDateTemplate = Expressions.dateTemplate(Date.class, "DATE({0})", cleanupData.cleanupDt);


//    @Override
//    public List<CleanupDataGroupByCoastResponseDto> cleanupDataGroupBySigungu(CleanupStatsDataRequestDto cleanupStatsDataRequestDto) {
//
//        DateTemplate<Date> startDate = Expressions.dateTemplate(Date.class, "DATE({0})", cleanupStatsDataRequestDto.getStartDate());
//        DateTemplate<Date> endDate = Expressions.dateTemplate(Date.class, "DATE({0})", cleanupStatsDataRequestDto.getEndDate());
//
//
//
//        // 시군코드, 시군이름, 해안코드, 해안명, 해안폴리곤, 수거량
//        return jpaQueryFactory.select(
//                        Projections.constructor(CleanupDataGroupByCoastResponseDto.class
//                        , sigunguInfo.sigunguCode
//                        , sigunguInfo.sigunguName
//                        , coastManageInfo.coastCode
//                        , coastManageInfo.coastName
//                        , coastManageInfo.coastGeom
//                        , cleanupData.totalCleanupLitter.sum().as("totalCleanupLitter")
//                        ))
//                .from(cleanupData)
//                .join(observedData).on(cleanupData.observedDataId.eq(observedData))
//                .join(coastManageInfo).on(observedData.coastCode.eq(coastManageInfo))
//                .join(sigunguInfo).on(coastManageInfo.sigunguCode.eq(sigunguInfo))
//                .where(cleanupDateTemplate.goe(startDate),
//                        cleanupDateTemplate.loe(endDate))
//                .groupBy(
//                        sigunguInfo.sigunguCode
//                        , sigunguInfo.sigunguName
//                        , coastManageInfo.coastCode
//                        , coastManageInfo.coastName
//                )
//                .fetch();
//
//    }

    @Override
    public List<MajorTypeOfLitterGroupByCoastResponseDto> MajorTypeOfLitterGroupByCoast(CleanupStatsDataRequestDto cleanupStatsDataRequestDto) {

        DateTemplate<Date> startDate = Expressions.dateTemplate(Date.class, "DATE({0})", cleanupStatsDataRequestDto.getStartDate());
        DateTemplate<Date> endDate = Expressions.dateTemplate(Date.class, "DATE({0})", cleanupStatsDataRequestDto.getEndDate());


        // 시군이름, 해안이름, 쓰레기종류, 수거량
        return jpaQueryFactory.select(
                        Projections.constructor(MajorTypeOfLitterGroupByCoastResponseDto.class
                                , sigunguInfo.sigunguCode
                                , sigunguInfo.sigunguName
                                , coastManageInfo.coastCode
                                , coastManageInfo.coastName
                                , coastManageInfo.coastGeom
                                , typesOfLitter.litterTypeName
                                , cleanupData.totalCleanupLitter.sum().as("totalCleanupLitter")
                        ))
                .from(cleanupData)
                .join(observedData).on(cleanupData.observedDataId.eq(observedData))
                .join(coastManageInfo).on(observedData.coastCode.eq(coastManageInfo))
                .join(sigunguInfo).on(coastManageInfo.sigunguCode.eq(sigunguInfo))
                .join(typesOfLitter).on(cleanupData.cleanupMajorLitter.eq(typesOfLitter))
                .where(cleanupDateTemplate.goe(startDate),
                        cleanupDateTemplate.loe(endDate))
                .groupBy(
                        sigunguInfo.sigunguCode
                        , sigunguInfo.sigunguName
                        , coastManageInfo.coastCode
                        , coastManageInfo.coastName
                        , coastManageInfo.coastGeom
                        , typesOfLitter.litterTypeName
                )
                .fetch();

    }

}

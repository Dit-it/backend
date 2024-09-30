package com.example.backend.repository;

import com.example.backend.dto.CleanupDataGroupBySigunguRequestDto;

import com.example.backend.dto.CleanupDataGroupBySigunguResponseDto;
import static com.example.backend.entity.QCleanupData.cleanupData;
import static com.example.backend.entity.QCoastManageInfo.coastManageInfo;
import static com.example.backend.entity.QObservedData.observedData;
import static com.example.backend.entity.QSigunguInfo.sigunguInfo;

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

    @Override
    public List<CleanupDataGroupBySigunguResponseDto> cleanupDataGroupBySigungu(CleanupDataGroupBySigunguRequestDto cleanupDataGroupBySigunguRequestDto) {

        DateTemplate<Date> cleanupDateTemplate = Expressions.dateTemplate(Date.class, "DATE({0})", cleanupData.cleanupDt);


        // 시군코드, 시군이름, 일자, 해안코드, 해안명, 수거량
        return jpaQueryFactory.select(
                        Projections.constructor(CleanupDataGroupBySigunguResponseDto.class
                        , sigunguInfo.sigunguCode
                        , sigunguInfo.sigunguName
                        , cleanupDateTemplate.as("cleanupDate") // 여기서 DateTemplate 사용
                        , coastManageInfo.coastCode
                        , coastManageInfo.coastName
                        , cleanupData.totalCleanupLitter.sum().as("totalCleanupLitter")
                        ))
                .from(cleanupData)
                .join(observedData).on(cleanupData.observedDataId.eq(observedData))
                .join(coastManageInfo).on(observedData.coastCode.eq(coastManageInfo))
                .join(sigunguInfo).on(coastManageInfo.sigunguCode.eq(sigunguInfo))
                .where(cleanupDateTemplate.goe(Date.valueOf(cleanupDataGroupBySigunguRequestDto.getStartDate())),
                        cleanupDateTemplate.loe(Date.valueOf(cleanupDataGroupBySigunguRequestDto.getEndDate())))
                .groupBy(
                        sigunguInfo.sigunguCode
                        , sigunguInfo.sigunguName
                        , cleanupDateTemplate
                        , coastManageInfo.coastCode
                        , coastManageInfo.coastName
                )
                .fetch();

    }
}

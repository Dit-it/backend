package com.example.backend.util;

import com.example.backend.dto.CleanupStatsDataRequestDto;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum ExcelColumnEnum {

    OB_MAJOR_LITTER("해안별_주요쓰레기_분포량(조사)", "observedMajorLitter", Arrays.asList("시군구명", "해안명", "주요 쓰레기")),
    CL_MAJOR_LITTER("해안별_주요쓰레기_분포량(청소)", "cleanupMajorLitter", Arrays.asList("시군구명", "해안명", "주요 쓰레기", "실제 수거량(L)")),
    OB_ESTIMATION ("해안별_수거예측량", "observedEstimation", Arrays.asList("시군구명", "해안명", "수거 예측량(L)")),
    CL_ESTIMATION ("해안별_실제수거량", "cleanupEstimation", Arrays.asList("시군구명", "해안명", "실제 수거량(L)")),
    TOT_ESTIMATION ("시군구별_누적수거량", "totEstimation", Arrays.asList("시군구명", "해안길이(M)", "누적 수거량(L)"));

    private String fileName;
    private String screen;
    private List<String> korColumnName;

    ExcelColumnEnum (String fileName, String screen, List<String> korColumnName) {
        this.fileName = fileName;
        this.screen = screen;
        this.korColumnName = korColumnName;
    }

    public static String getFileNameByScreeen(String screenName) {
        return Arrays.stream(ExcelColumnEnum.values())
                .filter(n -> n.getScreen().equals(screenName))
                .map(ExcelColumnEnum::getFileName)
                .findFirst().orElse(null);
    }

    public static List<String> getKorColumnList(String screenName) {
        return Arrays.stream(ExcelColumnEnum.values())
                .filter(n -> n.getScreen().equals(screenName))
                .map(ExcelColumnEnum::getKorColumnName)
                .findFirst()
                .orElse(new ArrayList<>());
    }


}

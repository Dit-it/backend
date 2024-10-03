package com.example.backend.dto;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TotalCleanupLitterGroupBySigunguResponseDto {

    private String sigunguCode;
    private String sigunguName;
    private Double coastLen; //시군 관리 해안선 길이
    private Integer totalCleanupLitter; //선택 기간 내 누적수거량

    public TotalCleanupLitterGroupBySigunguResponseDto(TotalCleanupLitterResponseInterface from) {
        this.sigunguCode = from.getSigunguCode();
        this.sigunguName = from.getSigunguName();
        this.coastLen = from.getCoastLen();
        this.totalCleanupLitter = from.getTotalCleanupLitter();
    }
}

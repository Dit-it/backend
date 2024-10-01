package com.example.backend.dto;

public interface TotalCleanupLitterResponseInterface {

        String getSigunguCode();
        String getSigunguName();
        Double getCoastLen(); //시군 관리 해안선 길이
        Integer getTotalCleanupLitter(); //선택 기간 내 누적수거량

}

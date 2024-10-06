package com.example.backend.dto;

import lombok.*;

public interface CoastManagaInfoResponseIntercase {

    Integer getCoastCode();
    String getCoastName();
    Double getCoastlineLen();
    String getCoastLonlat();
    String getSigunguCode();
    String getCoastGeom();
    String getSigunguName();
}

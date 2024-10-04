package com.example.backend.dto;


import org.geolatte.geom.Geometry;

public interface ObservedEstimationLitterGroupByCoastResponseInterface {

    String getSigunguName();
    String getSigunguCode();
    String getCoastName();
    Integer getCoastCode();
    Integer getEstimationLiterSum();
    Geometry getCoastLonlat();
    Geometry getCoastGeom();

}

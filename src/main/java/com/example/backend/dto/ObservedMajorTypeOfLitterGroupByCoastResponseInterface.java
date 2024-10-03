package com.example.backend.dto;

import org.geolatte.geom.Geometry;

public interface ObservedMajorTypeOfLitterGroupByCoastResponseInterface {
    String getSigunguName();
    String getSigunguCode();
    String getCoastName();
    Integer getCoastCode();
    String getObservedMajorLitterName();
    String getObservedMajorLitterCode();
    Geometry getCoastLonlat();
    Geometry getCoastGeom();
}

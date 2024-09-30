package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.locationtech.jts.geom.Geometry;

@Entity
public class SigunguInfo {
    @Id
    private String sigunguCode;
    private String sigunguName;
    private Geometry sigunguLonlat;
    private Geometry sigunguPolygon;
}

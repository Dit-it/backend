package com.example.backend.entity;

import jakarta.persistence.*;
import org.locationtech.jts.geom.Geometry;

@Entity
public class CoastManageInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer coastCode;
    private String coastName;
    private double coastlineLen;
    private Geometry coastLonlat;
    @ManyToOne
    @JoinColumn(name = "sigungu_code")
    private SigunguInfo sigunguCode;
    private Geometry coastGeom;

}

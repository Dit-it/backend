package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.geolatte.geom.Geometry;


@Getter
@Entity
public class CoastManageInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer coastCode;
    private String coastName;
    private double coastlineLen;
    private String coastLonlat;
    @ManyToOne
    @JoinColumn(name = "sigungu_code")
    private SigunguInfo sigunguCode;
    private String coastGeom;

}

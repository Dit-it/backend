package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.locationtech.jts.geom.Geometry;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SigunguInfo {
    @Id
    private String sigunguCode;
    private String sigunguName;
    private Geometry sigunguLonlat;
    private Geometry sigunguPolygon;
    private Boolean coastYn;
}

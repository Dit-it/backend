package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.geolatte.geom.Geometry;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SigunguInfo {
    @Id
    private String sigunguCode;
    private String sigunguName;
    private Geometry sigunguLonlat;
    private String sigunguPolygon;
    private Boolean coastYn;
}

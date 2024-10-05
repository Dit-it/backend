package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

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
    private String sigunguLonlat;
    private String sigunguPolygon;
    private Boolean coastYn;
}

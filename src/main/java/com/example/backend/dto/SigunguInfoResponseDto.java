package com.example.backend.dto;

import com.example.backend.entity.SigunguInfo;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SigunguInfoResponseDto {

    private String sigunguCode;
    private String sigunguName;
    private String sigunguPolygon;
    private Boolean coastYn;

    public SigunguInfoResponseDto(SigunguInfo sigunguInfo) {
        this.sigunguCode = sigunguInfo.getSigunguCode();
        this.sigunguName = sigunguInfo.getSigunguName();
        this.sigunguPolygon = sigunguInfo.getSigunguPolygon();
        this.coastYn = sigunguInfo.getCoastYn();
    }
}

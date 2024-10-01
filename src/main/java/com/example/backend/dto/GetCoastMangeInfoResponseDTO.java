package com.example.backend.dto;

import com.example.backend.entity.CoastManageInfo;
import com.example.backend.entity.SigunguInfo;
import lombok.*;
import org.locationtech.jts.geom.Geometry;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class GetCoastMangeInfoResponseDTO {

    private Integer coastCode;
    private String coastName;
    private double coastlineLen;
    private Geometry coastLonlat;
    private SigunguInfo sigunguCode;
    private Geometry coastGeom;

    public GetCoastMangeInfoResponseDTO(CoastManageInfo coastManageInfo) {
        this.coastCode = coastManageInfo.getCoastCode();
        this.coastName = coastManageInfo.getCoastName();
        this.coastlineLen = coastManageInfo.getCoastlineLen();
        this.coastLonlat = coastManageInfo.getCoastLonlat();
        this.sigunguCode = coastManageInfo.getSigunguCode();
        this.coastGeom = coastManageInfo.getCoastGeom();
    }

}

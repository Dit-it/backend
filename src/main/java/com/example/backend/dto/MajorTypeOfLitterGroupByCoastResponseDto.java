package com.example.backend.dto;

import lombok.*;
import org.locationtech.jts.geom.Geometry;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MajorTypeOfLitterGroupByCoastResponseDto {

    private String sigunguCode;
    private String sigunguName;
    private Integer coastCode;
    private String coastName;
    private Geometry coastGeom;
    private String litterTypeName;
    private Integer totalCleanupLitter;

    public MajorTypeOfLitterGroupByCoastResponseDto (MajorTypeOfLitterGroupByCoastResponseInterface interfaceDto){
        this.sigunguCode = interfaceDto.getSigunguCode();
        this.sigunguName = interfaceDto.getSigunguName();
        this.litterTypeName = interfaceDto.getLitterTypeName();
        this.totalCleanupLitter = interfaceDto.getTotalCleanupLitter();
    }

}

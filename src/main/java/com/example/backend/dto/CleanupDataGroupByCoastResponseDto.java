package com.example.backend.dto;
import lombok.*;
import org.locationtech.jts.geom.Geometry;

import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CleanupDataGroupByCoastResponseDto {

    private String sigunguCode;
    private String sigunguName;
    private Date cleanupDate;
    private Integer coastCode;
    private String coastName;
    private String coastGeom;
    private Integer totalCleanupLitter;

    public CleanupDataGroupByCoastResponseDto(String sigunguCode, String sigunguName, Integer coastCode, String coastName, String coastGeom, Integer totalCleanupLitter) {
        this.sigunguCode = sigunguCode;
        this.sigunguName = sigunguName;
        this.coastCode = coastCode;
        this.coastName = coastName;
        this.coastGeom = coastGeom;
        this.totalCleanupLitter = totalCleanupLitter;
    }

}

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
    private Geometry coastGeom;
    private Integer totalCleanupLitter;

}

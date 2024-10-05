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
    private Integer coastCode;
    private String coastName;
    private String coastLonlat;
    private Integer totalCleanupLitter;

    public CleanupDataGroupByCoastResponseDto(CleanupDataGroupByCoastResponseInterface interfaceDto) {
        this.sigunguCode = interfaceDto.getSigunguCode();
        this.sigunguName = interfaceDto.getSigunguName();
        this.coastCode = interfaceDto.getCoastCode();
        this.coastName = interfaceDto.getCoastName();
        this.coastLonlat = interfaceDto.getCoastLonlat();
        this.totalCleanupLitter = interfaceDto.getTotalCleanupLitter();
    }

}

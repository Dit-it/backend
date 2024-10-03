package com.example.backend.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MajorTypeOfLitterGroupByCoastResponseDto {

    private String sigunguCode;
    private String sigunguName;
    private String coastCode;
    private String coastName;
    private String coastGeom;
    private String litterTypeName;
    private Integer totalCleanupLitter;

}

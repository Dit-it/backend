package com.example.backend.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MajorTypeOfLitterGroupByCoastResponseDto {

    private String sigunguName;
    private String coastName;
    private String litterTypeName;
    private Integer totalCleanupLitter;

}

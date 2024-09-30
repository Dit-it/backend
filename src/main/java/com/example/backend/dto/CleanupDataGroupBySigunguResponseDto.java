package com.example.backend.dto;
import lombok.*;
import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CleanupDataGroupBySigunguResponseDto {

    private String sigunguCode;
    private String sigunguName;
    private Date cleanupDate;
    private Integer coastCode;
    private String coastName;
    private Integer totalCleanupLitter;

}

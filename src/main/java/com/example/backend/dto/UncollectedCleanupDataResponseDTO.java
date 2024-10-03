package com.example.backend.dto;

import com.example.backend.entity.CleanupData;
import lombok.*;

@Getter
@Setter
@ToString @EqualsAndHashCode
@NoArgsConstructor
public class UncollectedCleanupDataResponseDTO {
    private Integer cleanupDataId;
    private String collectionPicture;
    private Integer totalCleanupLitter;
    private Double lon;
    private Double lat;

    public UncollectedCleanupDataResponseDTO(CleanupData cleanupData) {
        this.cleanupDataId = cleanupData.getCleanupDataId();
        this.collectionPicture = cleanupData.getCollectionPicture();
        this.totalCleanupLitter = cleanupData.getTotalCleanupLitter();
        this.lon = cleanupData.getCollectionLonlat().getCoordinate().getX();
        this.lat = cleanupData.getCollectionLonlat().getCoordinate().getY();
    }
}

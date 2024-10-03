package com.example.backend.dto;

import com.example.backend.util.GeometryConverter;
import lombok.*;
import org.locationtech.jts.geom.Geometry;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ObservedMajorTypeOfLitterGroupByCoastResponseDTO {

    private String sigunguName;
    private String sigunguCode;
    private String coastName;
    private Integer coastCode;
    private String observedMajorLitterName;
    private String observedMajorLitterCode;
    private Geometry coastLonlat;
    private Geometry coastGeom;

    public ObservedMajorTypeOfLitterGroupByCoastResponseDTO(ObservedMajorTypeOfLitterGroupByCoastResponseInterface itf) {
        GeometryConverter geometryConverter = new GeometryConverter();
        this.sigunguName = itf.getSigunguName();
        this.sigunguCode = itf.getSigunguCode();
        this.coastName = itf.getCoastName();
        this.coastCode = itf.getCoastCode();
        this.observedMajorLitterName = itf.getObservedMajorLitterName();
        this.observedMajorLitterCode = itf.getObservedMajorLitterCode();
        this.coastLonlat = geometryConverter.convert(itf.getCoastLonlat());
        this.coastGeom = geometryConverter.convert(itf.getCoastGeom());
    }
}

package com.example.backend.dto;
import com.example.backend.util.GeometryConverter;
import lombok.*;
import org.locationtech.jts.geom.Geometry;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ObservedEstimationLitterGroupByCoastResponseDTO {

    private String sigunguName;
    private String sigunguCode;
    private String coastName;
    private Integer coastCode;
    private Integer estimationLiterSum;
    private Geometry coastLonlat;
    private Geometry coastGeom;

    public ObservedEstimationLitterGroupByCoastResponseDTO(ObservedEstimationLitterGroupByCoastResponseInterface itf) {
        GeometryConverter converter = new GeometryConverter();
        this.sigunguName = itf.getSigunguName();
        this.sigunguCode = itf.getSigunguCode();
        this.coastName = itf.getCoastName();
        this.coastCode = itf.getCoastCode();
        this.estimationLiterSum = itf.getEstimationLiterSum();
        this.coastLonlat = converter.convert(itf.getCoastLonlat());
        this.coastGeom = converter.convert(itf.getCoastGeom());
    }

}

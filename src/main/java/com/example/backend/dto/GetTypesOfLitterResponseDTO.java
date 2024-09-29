package com.example.backend.dto;

import com.example.backend.entity.TypesOfLitter;
import lombok.*;

@Getter
@Setter
@ToString @EqualsAndHashCode
@NoArgsConstructor
public class GetTypesOfLitterResponseDTO {
    private String litterTypeCode;
    private String litterTypeName;
    private String litterColor;

    public GetTypesOfLitterResponseDTO(TypesOfLitter typesOfLitter) {
        this.litterTypeCode = typesOfLitter.getLitterTypeCode();
        this.litterTypeName = typesOfLitter.getLitterTypeName();
        this.litterColor = typesOfLitter.getLitterColor();
    }
}

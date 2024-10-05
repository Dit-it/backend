package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@Entity
public class TypesOfLitter {
    @Id
    private String litterTypeCode;
    private String litterTypeName;
    private String litterColor;
    private String litterIcon;
}

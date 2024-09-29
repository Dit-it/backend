package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class TypesOfLiter {
    @Id
    private String litterTypeCode;
    private String litterTypeName;
    private String litterColor;
}

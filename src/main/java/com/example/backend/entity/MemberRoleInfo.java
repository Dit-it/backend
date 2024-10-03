package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberRoleInfo {

    @Id
    private String roleCode;
    private String roleName;
    private String authCode;
}
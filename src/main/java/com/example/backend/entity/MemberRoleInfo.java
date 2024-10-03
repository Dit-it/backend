package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@ToString
public class MemberRoleInfo {

    @Id
    private String roleCode;
    private String roleName;
    private String authCode;
}
package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MemberRoleInfo {

    @Id
    private String roleCode;
    private String roleName;
    private String authCode;
}
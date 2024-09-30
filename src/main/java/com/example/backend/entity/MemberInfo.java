package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class MemberInfo {

    @Id
    private String memberId;
    private String password;
    private String memberName;
    @ManyToOne
    @JoinColumn(name = "role_code")
    private MemberRoleInfo roleCode;
}

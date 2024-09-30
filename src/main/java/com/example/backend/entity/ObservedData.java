package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class ObservedData {

    @Id
    private String observedDataId;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberInfo memberId;
    @ManyToOne
    @JoinColumn(name = "coast_code")
    private CoastManageInfo coastCode;
    private Integer estimationLiter;
    private String observedPicture;
    private LocalDateTime observedDt;
    @ManyToOne
    @JoinColumn(name = "cleanup_major_litter")
    private TypesOfLitter cleanupMajorLitter;
}
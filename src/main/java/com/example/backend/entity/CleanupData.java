package com.example.backend.entity;

import jakarta.persistence.*;
import org.locationtech.jts.geom.Geometry;

import java.time.LocalDateTime;

@Entity
public class CleanupData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cleanupDataId;
    @ManyToOne
    @JoinColumn(name="member_id")
    private MemberInfo memberId;
    @OneToOne
    @JoinColumn(name="ovserved_data_id")
    private ObservedData observedDataId;
    private String beforeCleanupPicture;
    private String afterCleanupPicture;
    private LocalDateTime cleanupDt;
    private Integer count50liter;
    private Integer totalCleanupLitter;
    private Geometry collectionLonlat;
    @ManyToOne
    @JoinColumn(name = "cleanup_major_litter")
    private TypesOfLitter cleanupMajorLitter;
    private boolean collectionStatus;
    private String collectionLocationMemo;
}

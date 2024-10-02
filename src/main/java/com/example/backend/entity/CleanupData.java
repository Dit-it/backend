package com.example.backend.entity;

import com.example.backend.dto.SaveCleanupDataRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Builder
public class CleanupData {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cleanupDataId;
    @ManyToOne
    @JoinColumn(name="member_id")
    private MemberInfo memberId;
    @OneToOne
    @JoinColumn(name="observed_data_id")
    private ObservedData observedDataId;
    private String beforeCleanupPicture;
    private String afterCleanupPicture;
    private LocalDateTime cleanupDt;
    @Column(name = "count_50liter")
    private Integer count50liter;
    private Integer totalCleanupLitter;
    private Geometry collectionLonlat;
    private String collectionPicture;
    @ManyToOne
    @JoinColumn(name = "cleanup_major_litter")
    private TypesOfLitter cleanupMajorLitter;
    private boolean collectionStatus;
    private String collectionLocationMemo;
    @ManyToOne
    @JoinColumn(name="driver_member_id")
    private MemberInfo driverMemberId;
}

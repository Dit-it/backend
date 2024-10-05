package com.example.backend.repository;

import com.example.backend.entity.SigunguInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SigunguRepository extends JpaRepository<SigunguInfo, Long> {

    @Query(value = "select sigungu_code, sigungu_name, sigungu_lonlat, st_asgeojson(sigungu_polygon)::jsonb as sigungu_polygon, coast_yn from sigungu_info", nativeQuery = true)
    List<SigunguInfo> findSimple();
}

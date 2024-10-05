package com.example.backend.repository;

import com.example.backend.entity.SigunguInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SigunguRepository extends JpaRepository<SigunguInfo, Long> {

    @Query(value = "WITH polygons AS ( " +
            "    SELECT " +
            "        sigungu_code, " +
            "        sigungu_name, " +
            "        coast_yn, " +
            "        sigungu_lonlat, " +
            "        (ST_Dump(sigungu_polygon)).geom AS sigungu_polygon " +
            "    FROM sigungu_info " +
            "), " +
            "ranked_polygons AS ( " +
            "    SELECT " +
            "        sigungu_code, " +
            "        sigungu_name, " +
            "        coast_yn, " +
            "        sigungu_polygon, " +
            "        sigungu_lonlat, " +
            "        ROW_NUMBER() OVER (PARTITION BY sigungu_code ORDER BY ST_Area(sigungu_polygon) DESC) AS rank " +
            "    FROM polygons " +
            ") " +
            "SELECT " +
            "    sigungu_code, " +
            "    sigungu_name, " +
            "        coast_yn, " +
            "        ST_AsGeoJSON(sigungu_lonlat)::jsonb as sigungu_lonlat, " +
            "    ST_AsGeoJSON(sigungu_polygon)::jsonb AS sigungu_polygon " +
            "FROM ranked_polygons " +
            "WHERE rank = 1 " +
            "ORDER BY ST_Area(sigungu_polygon) DESC;", nativeQuery = true)
    List<SigunguInfo> findSimple();
}

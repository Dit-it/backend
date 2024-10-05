package com.example.backend.repository;

import com.example.backend.dto.ObservedEstimationLitterGroupByCoastResponseDTO;
import com.example.backend.dto.ObservedEstimationLitterGroupByCoastResponseInterface;
import com.example.backend.dto.ObservedMajorTypeOfLitterGroupByCoastResponseInterface;
import com.example.backend.entity.ObservedData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ObservedDataRepository extends JpaRepository<ObservedData, String> {

    @Query(value = "SELECT s.sigungu_name, s.sigungu_code, c.coast_name, sub.coast_code, " +
            "STRING_AGG(t.litter_type_name, ', ') AS observed_major_litter_name, " +
            "STRING_AGG(sub.observed_major_litter, ', ') AS observed_major_litter_code, " +
            "ST_AsGeoJSON(c.coast_lonlat)::jsonb as coast_lonlat, ST_AsGeoJSON(c.coast_geom)::jsonb as coast_geom " +
            "FROM ( " +
            "   SELECT coast_code, observed_major_litter, COUNT(observed_major_litter) AS major_count, " +
            "          RANK() OVER (PARTITION BY coast_code ORDER BY COUNT(observed_major_litter) DESC) AS rk " +
            "   FROM public.observed_data " +
            "   WHERE observed_dt BETWEEN :startDate AND :endDate " +
            "   GROUP BY coast_code, observed_major_litter " +
            ") AS sub " +
            "JOIN public.coast_manage_info c ON sub.coast_code = c.coast_code " +
            "JOIN public.sigungu_info s ON c.sigungu_code = s.sigungu_code " +
            "JOIN public.types_of_litter t ON sub.observed_major_litter = t.litter_type_code " +
            "WHERE rk = 1 " +
            "GROUP BY sub.coast_code, c.coast_name, s.sigungu_name, s.sigungu_code, c.coast_lonlat, c.coast_geom",
            nativeQuery = true)
    List<ObservedMajorTypeOfLitterGroupByCoastResponseInterface> searchObservedMajorLitterByCoast(LocalDate startDate, LocalDate endDate);

    @Query(value = "SELECT s.sigungu_name AS sigunguName, s.sigungu_code AS sigunguCode, " +
            "c.coast_name AS coastName, d.coast_code AS coastCode, " +
            "SUM(d.estimation_liter) AS estimation_liter_sum, " +
            "ST_AsGeoJSON(c.coast_lonlat)::jsonb AS coast_lonlat, ST_AsGeoJSON(c.coast_geom)::jsonb AS coast_geom " +
            "FROM public.observed_data d " +
            "JOIN public.coast_manage_info c ON d.coast_code = c.coast_code " +
            "JOIN public.sigungu_info s ON c.sigungu_code = s.sigungu_code " +
            "WHERE d.observed_dt BETWEEN :startDate AND :endDate " +
            "GROUP BY s.sigungu_name, s.sigungu_code, c.coast_name, d.coast_code, c.coast_lonlat, c.coast_geom",
            nativeQuery = true)
    List<ObservedEstimationLitterGroupByCoastResponseInterface> searchObservedEstimationLitterByCoast(LocalDate startDate, LocalDate endDate);

}

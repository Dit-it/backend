package com.example.backend.repository;

import com.example.backend.dto.CoastManagaInfoResponseIntercase;
import com.example.backend.dto.GetCoastMangeInfoResponseDTO;
import com.example.backend.entity.CoastManageInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoastManageInfoRepository extends JpaRepository<CoastManageInfo, Integer> {

    @Query(value = "SELECT cmi.sigungu_code, sigungu_name, coast_code, coast_name, " +
            "coastline_len, st_asgeojson(coast_lonlat)::jsonb as coast_lonlat, st_asgeojson(coast_geom)::jsonb as coast_geom " +
            "FROM public.coast_manage_info cmi " +
            "Join sigungu_info si on si.sigungu_code = cmi.sigungu_code " +
            "WHERE cmi.sigungu_code = :sigunguCode", nativeQuery = true)
    List<CoastManagaInfoResponseIntercase> findAllBySigunguCode(String sigunguCode);

    @Query(value = "SELECT cmi.sigungu_code, sigungu_name, coast_code, coast_name, " +
            "coastline_len, st_asgeojson(coast_lonlat)::jsonb as coast_lonlat, st_asgeojson(coast_geom)::jsonb as coast_geom " +
            "FROM public.coast_manage_info cmi Join sigungu_info si on si.sigungu_code = cmi.sigungu_code ", nativeQuery = true)
    List<CoastManagaInfoResponseIntercase> findAllCoastInfo();


}

package com.example.backend.repository;


import com.example.backend.dto.*;
import com.example.backend.entity.CleanupData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CleanupDataRepository extends JpaRepository<CleanupData, Integer> {

    @Query(value = "SELECT si.sigungu_code as sigunguCode, si.sigungu_name as sigunguName, si.coast_len as coastLen, SUM(cd.total_cleanup_litter) AS totalCleanupLitter " +
            "FROM cleanup_data cd " +
            "JOIN observed_data od ON cd.observed_data_id = od.observed_data_id " +
            "JOIN coast_manage_info cmi ON cmi.coast_code = od.coast_code " +
            "JOIN ( " +
            "    SELECT si.sigungu_code, si.sigungu_name, SUM(ROUND((coastline_len / 1000)::numeric, 2)) AS coast_len " +
            "    FROM coast_manage_info " +
            "    JOIN sigungu_info si ON coast_manage_info.sigungu_code = si.sigungu_code " +
            "    GROUP BY si.sigungu_code, si.sigungu_name " +
            ") si ON cmi.sigungu_code = si.sigungu_code " +
            "WHERE date(cd.cleanup_dt) BETWEEN ?1 AND ?2 " +
            "GROUP BY si.sigungu_code, si.sigungu_name, si.coast_len", nativeQuery = true)
    List<TotalCleanupLitterResponseInterface> totalCollectedLitterByCoast(LocalDate startDate, LocalDate endDate);

    @Query(value = "select" +
            "            si1_0.sigungu_code, " +
            "            si1_0.sigungu_name, " +
            "            tol.litter_type_name, " +
            "            sum(cd1_0.total_cleanup_litter) as total_cleanup_litter " +
            "        from " +
            "            cleanup_data cd1_0" +
            "        join" +
            "            observed_data od1_0 " +
            "                on cd1_0.observed_data_id=od1_0.observed_data_id " +
            "        join " +
            "            coast_manage_info cmi1_0 " +
            "                on od1_0.coast_code=cmi1_0.coast_code " +
            "        join " +
            "            sigungu_info si1_0 " +
            "                on cmi1_0.sigungu_code=si1_0.sigungu_code " +
            "        join types_of_litter tol on cd1_0.cleanup_major_litter = tol.litter_type_code " +
            "        WHERE date(cd1_0.cleanup_dt) BETWEEN ?1 AND ?2 " +
            "        group by " +
            "            si1_0.sigungu_code, " +
            "            si1_0.sigungu_name, " +
            "            tol.litter_type_name " +
            "order by sigungu_name, litter_type_name", nativeQuery = true)
    List<MajorTypeOfLitterGroupByCoastResponseInterface> MajorTypeOfLitterGroupBySigungu(LocalDate startDate, LocalDate endDate);

    List<CleanupData> findAllByCollectionStatusFalse();

    @Query(value = "        select " +
            "            si1_0.sigungu_code, " +
            "            si1_0.sigungu_name, " +
            "            cmi1_0.coast_code, " +
            "            cmi1_0.coast_name, " +
            "            st_asgeojson(cmi1_0.coast_lonlat) as coast_lonlat, " +
            "            sum(cd1_0.total_cleanup_litter) as total_cleanup_litter" +
            "        from " +
            "            cleanup_data cd1_0 " +
            "        join " +
            "            observed_data od1_0 " +
            "                on cd1_0.observed_data_id=od1_0.observed_data_id " +
            "        join " +
            "            coast_manage_info cmi1_0 " +
            "                on od1_0.coast_code=cmi1_0.coast_code " +
            "        join " +
            "            sigungu_info si1_0 " +
            "                on cmi1_0.sigungu_code=si1_0.sigungu_code " +
            "        WHERE date(cd1_0.cleanup_dt) BETWEEN ?1 AND ?2 " +
            "        group by " +
            "            si1_0.sigungu_code, " +
            "            si1_0.sigungu_name, " +
            "            cmi1_0.coast_code, " +
            "            cmi1_0.coast_name", nativeQuery = true)
    List<CleanupDataGroupByCoastResponseInterface> cleanupDataGroupBySigungu(LocalDate startDate, LocalDate endDate);
}

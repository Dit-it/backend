package com.example.backend.repository;


import com.example.backend.dto.TotalCleanupLitterResponseInterface;
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
}

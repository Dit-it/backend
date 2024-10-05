package com.example.backend.repository;

import com.example.backend.dto.GetCoastMangeInfoResponseDTO;
import com.example.backend.entity.CoastManageInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoastManageInfoRepository extends JpaRepository<CoastManageInfo, Integer> {

    List<CoastManageInfo> findAllBySigunguCode_SigunguCode(String sigunguCode);
}

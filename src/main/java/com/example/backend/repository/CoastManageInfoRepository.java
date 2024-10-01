package com.example.backend.repository;

import com.example.backend.entity.CoastManageInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoastManageInfoRepository extends JpaRepository<CoastManageInfo, Integer> {
}

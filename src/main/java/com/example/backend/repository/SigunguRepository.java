package com.example.backend.repository;

import com.example.backend.entity.SigunguInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SigunguRepository extends JpaRepository<SigunguInfo, Long> {

}

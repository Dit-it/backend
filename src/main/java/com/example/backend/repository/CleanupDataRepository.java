package com.example.backend.repository;


import com.example.backend.entity.CleanupData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleanupDataRepository extends JpaRepository<CleanupData, Integer> {
}

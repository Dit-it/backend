package com.example.backend.repository;

import com.example.backend.entity.ObservedData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservedDataRepository extends JpaRepository<ObservedData, String> {
}

package com.example.backend.repository;

import com.example.backend.entity.TypesOfLitter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypesOfLitterRepository extends JpaRepository<TypesOfLitter, String> {
}

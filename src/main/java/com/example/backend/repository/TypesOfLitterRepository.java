package com.example.backend.repository;

import com.example.backend.entity.TypesOfLitter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface TypesOfLitterRepository extends JpaRepository<TypesOfLitter, String> {
    List<TypesOfLitter> findAllByOrderByLitterTypeCode();
}

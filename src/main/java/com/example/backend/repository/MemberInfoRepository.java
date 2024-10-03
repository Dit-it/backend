package com.example.backend.repository;

import com.example.backend.entity.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberInfoRepository extends JpaRepository<MemberInfo, String> {

    Optional<MemberInfo> findByMemberId(String memberId);

}

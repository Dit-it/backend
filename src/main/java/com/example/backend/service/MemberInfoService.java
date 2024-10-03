package com.example.backend.service;

import com.example.backend.entity.MemberInfo;
import org.springframework.security.core.userdetails.UserDetails;

public interface MemberInfoService {

    UserDetails loadUserByUsername(String memberId);

}

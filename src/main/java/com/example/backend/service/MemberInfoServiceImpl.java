package com.example.backend.service;

import com.example.backend.entity.MemberInfo;
import com.example.backend.repository.MemberInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberInfoServiceImpl implements MemberInfoService, UserDetailsService {

    private final MemberInfoRepository memberInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String memberId) {
        return memberInfoRepository.findByMemberId(memberId)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 회원을 찾을 수 없습니다."));
    }

    // 해당하는 User 의 데이터가 존재한다면 UserDetails 객체로 만들어서 return
    private UserDetails createUserDetails(MemberInfo memberInfo) {
        return User.builder()
                .username(memberInfo.getUsername())
//                .password(passwordEncoder.encode(member.getPassword()))
                .password("{noop}" + memberInfo.getPassword())
                .roles(String.valueOf(memberInfo.getRoleCode().getRoleCode()))
                .build();
    }

}

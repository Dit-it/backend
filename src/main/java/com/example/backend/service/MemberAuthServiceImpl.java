package com.example.backend.service;

import com.example.backend.dto.JwtToken;
import com.example.backend.dto.SigninDto;
import com.example.backend.repository.MemberInfoRepository;
import com.example.backend.util.JwtTokenProvider;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberAuthServiceImpl implements MemberAuthService {
    private final MemberInfoRepository memberInfoRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    @Override
    public JwtToken signIn(SigninDto signinDto) {
        // memberId + password 를 기반으로 Authentication 객체 생성
        String memberId = signinDto.getMemberId();
        String password = signinDto.getPassword();

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberId, password);

        // authenticate() 메서드를 통해 요청된 Member 에 대한 검증
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 인증 정보를 기반으로 JWT 토큰 생성
        return jwtTokenProvider.generateToken(authentication);

    }

}

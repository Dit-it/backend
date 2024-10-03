package com.example.backend.controller;

import com.example.backend.dto.JwtToken;
import com.example.backend.dto.SigninDto;
import com.example.backend.entity.MemberInfo;
import com.example.backend.service.MemberAuthService;
import com.example.backend.util.JwtTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class MemberInfoController {

    private final MemberAuthService memberAuthService;
    private final JwtTokenProvider jwtTokenProvider;


    @PostMapping
    public JwtToken signIn(@RequestBody SigninDto signinDto) {
        return memberAuthService.signIn(signinDto);
    }

    @PostMapping("/test")
    public MemberInfo test(@AuthenticationPrincipal MemberInfo memberInfo){
        System.out.println("memberInfo = " + memberInfo);
        return memberInfo;
    }

}

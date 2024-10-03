package com.example.backend.controller;

import com.example.backend.dto.JwtToken;
import com.example.backend.dto.SigninDto;
import com.example.backend.service.MemberAuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class MemberInfoController {

    private final MemberAuthService memberAuthService;

    @PostMapping
    public JwtToken signIn(@RequestBody SigninDto signinDto) {
        log.info("request userId = {}, password = {}", signinDto.getMemberId(), signinDto.getPassword());
        JwtToken jwtToken = memberAuthService.signIn(signinDto);
        log.info("jwtToken accessToken = {}, refreshToken = {}", jwtToken.getAccessToken(), jwtToken.getRefreshToken());
        return jwtToken;
    }

    @PostMapping("/test")
    public String test(){
        return "good";
    }

}

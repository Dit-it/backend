package com.example.backend.service;

import com.example.backend.dto.JwtToken;
import com.example.backend.dto.SigninDto;

public interface MemberAuthService {

    JwtToken signIn(SigninDto signinDto);

}

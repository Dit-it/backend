package com.example.backend.config;

import com.example.backend.util.JwtAuthenticationFilter;
import com.example.backend.util.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //csrf 해제
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                //세션 사용하지 않음
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        //로그인에 대해 모든 요청 허가
                        .requestMatchers(new AntPathRequestMatcher("/login")).permitAll()
                        //이외에는 권한 있어야 가능
//                        .requestMatchers(new AntPathRequestMatcher("/login/test")).hasRole("R01") //개발 완료 후 최종 수정
                        .requestMatchers(new AntPathRequestMatcher("/**")).permitAll() //개발 완료 후 최종 수정
                        .anyRequest().authenticated()
                )
                //UsernamePasswordAuthenticationFilter 전에 JwtAuthenticationFilter 실행
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCrypt Encoder
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}

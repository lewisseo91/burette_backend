package com.takeon.burette.infrastructure;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class JwtTokenProviderTest {

    @Test
    public void createTokenTest() {
        // 토큰 생성 테스트
        String payload = "donghyun";
        // 토큰 생성 기능
        JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
        String token = jwtTokenProvider.createToken(payload);
        System.out.println(token);
    }

    // 토큰 검증 기능 필요
    @Test
    public void validateToken() {
        // 토큰 생성 테스트
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkb25naHl1biIsImlhdCI6MTYxNzcxNzIxOSwiZXhwIjoxNjIwMzA5MjE5fQ.8BFmom-e1_WyPK-pkgOiNqdo6B69eqm9HsTyC-sloqAgd";
        // 토큰 생성 기능
        JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
        assertThat(jwtTokenProvider.validToken(token)).isFalse();
    }

    @Test
    public void getPayloadTest() {
        // 토큰 생성 테스트
        String payload = "donghyun";
        // 토큰 생성 기능
        JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
        String token = jwtTokenProvider.createToken(payload);
        String resultPayload = jwtTokenProvider.getPayload(token);
        assertThat(resultPayload).isEqualTo(payload);
    }


}

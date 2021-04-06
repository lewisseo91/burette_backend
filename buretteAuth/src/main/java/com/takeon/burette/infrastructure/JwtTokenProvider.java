package com.takeon.burette.infrastructure;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

// TODO : Component 이해
@Component
public class JwtTokenProvider {

//    @Value("${security.jwt.token.s}")
    private static String secretKey = "dlksagjlkdsajglkdsasdjgdasd";

//    @Value("${security.jwt.token.e}")
    private long expireLengthInMilliSecond = 2592000000L;

    public String createToken(String payload) {
        Claims claims = Jwts.claims().setSubject(payload);
        Date now = new Date();
        Date validity = new Date(now.getTime() + expireLengthInMilliSecond);
        return Jwts.builder()
                    .setClaims(claims)
                    .setIssuedAt(now)
                    .setExpiration(validity)
                    .signWith(SignatureAlgorithm.HS256, secretKey)
                    .compact();
    }

    public String getPayload(String token) {
        return Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
    }

    public boolean validToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return !claimsJws.getBody().getExpiration().before(new Date());
        } catch (JwtException|IllegalArgumentException e) {
//            e.printStackTrace();
            System.out.println("invalid token");
        }
        return false;
    }


}

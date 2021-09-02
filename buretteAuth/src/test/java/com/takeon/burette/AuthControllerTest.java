package com.takeon.burette;

import com.takeon.burette.infrastructure.JwtTokenProvider;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthControllerTest extends AcceptanceTest {

    @Test
    void generateTokenTest() {
        String payload = "abcd123";
        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .when().get("/auth/create/" +payload)
                .then().log().all()
                .extract();

        JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
        String token = jwtTokenProvider.createToken(payload);

        assertThat(res.body().asString()).isEqualTo(token);
    }

    @Test
    void getIdFromTokenTest() {
        String payload = "abcd123";
        JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
        String token = jwtTokenProvider.createToken(payload);
        System.out.println(token);
        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .when().get("/auth/valid/" +token)
                .then().log().all()
                .extract();

        assertThat(res.body().asString()).isEqualTo(payload);
    }

}
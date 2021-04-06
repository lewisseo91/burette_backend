package com.takeon.burette;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthControllerTest extends AcceptanceTest {

    @Test
    void generateTokenTest() {
//        String payload = "abcd123";
//        ExtractableResponse<Response> res = RestAssured
//                .given().log().all()
//                .when().get("/auth/create?id=" +payload)
//                .then().log().all()
//                .extract();
//        JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
//        String token = jwtTokenProvider.createToken(payload);
//       assertThat(res.body().toString()).isEqualTo(token);
    }

}
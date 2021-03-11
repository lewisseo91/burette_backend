package com.takeon.burette.user;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import com.takeon.burette.AcceptanceTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

public class UserControllerTest extends AcceptanceTest {

    @Test
    void testTest() {
        System.out.println("asdb");
        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .when().get("/user/test")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void createUserTest() {
        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .contentType("application/json")
                .body("{\"title\": \"Effective Java\", \"isbn\":\"978-0-13-468599-1\", \"author\":\"Joshua Bloch\"}")
                .when().post("/user/create")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
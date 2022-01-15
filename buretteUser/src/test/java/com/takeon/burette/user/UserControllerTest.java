package com.takeon.burette.user;

import com.takeon.burette.AcceptanceTest;
import com.takeon.burette.user.dto.LoginRequest;
import com.takeon.burette.user.dto.UserRequest;
import com.takeon.burette.user.dto.UserResponse;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.List;

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
        UserRequest userRequest = new UserRequest("abcd123", "123456", "abc", "abc", "000", "000", 0, 0);

        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .contentType("application/json")
//                .body("{\"userId\": \"Effective Java\", \"isbn\":\"978-0-13-468599-1\", \"author\":\"Joshua Bloch\"}")
                .body(userRequest)
                .when().post("/user/create")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void loginUserTest() {
        UserRequest userRequest = new UserRequest("abcd123", "123456", "abc", "abc", "000", "000", 0, 0);
        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .contentType("application/json")
//                .body("{\"userId\": \"Effective Java\", \"isbn\":\"978-0-13-468599-1\", \"author\":\"Joshua Bloch\"}")
                .body(userRequest)
                .when().post("/user/create")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());

        LoginRequest loginRequest = new LoginRequest("abcd123", "123456");
        ExtractableResponse<Response> res2 = RestAssured
                .given().log().all()
                .contentType("application/json")
//                .body("{\"userId\": \"Effective Java\", \"isbn\":\"978-0-13-468599-1\", \"author\":\"Joshua Bloch\"}")
                .body(loginRequest)
                .when().post("/user/login")
                .then().log().all()
                .extract();
        assertThat(res2.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void getUsersTest() {
        createUserTest();

        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("/user/users")
                .then().log().all()
                .extract();

//        System.out.println(res.body().asString());
        List<UserResponse> responses = res.body().jsonPath().getList(".", UserResponse.class);

//        for (UserResponse userResponse: responses) {
//            System.out.println(userResponse.getUserId());
//        }

        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
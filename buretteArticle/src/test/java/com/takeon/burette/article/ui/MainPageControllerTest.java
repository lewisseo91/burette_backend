package com.takeon.burette.article.ui;

import com.takeon.burette.AcceptanceTest;
import com.takeon.burette.article.dto.MainPageRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageControllerTest extends AcceptanceTest {

    @Test
    void testMainPageTest() {
        MainPageRequest mainPageRequest = new MainPageRequest(1);
        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("/main/test")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
    }


    @Test
    void createMainPageTest() {
        MainPageRequest mainPageRequest = new MainPageRequest(1);
        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(mainPageRequest)
                .when().post("/main/create")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
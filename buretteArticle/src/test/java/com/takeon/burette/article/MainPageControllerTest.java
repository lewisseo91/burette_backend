package com.takeon.burette.article;

import com.takeon.burette.AcceptanceTest;
import com.takeon.burette.article.dto.MainPageRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageControllerTest extends AcceptanceTest {

    @Test
    void testMainPageTest() {
        MainPageRequest mainPageRequest = new MainPageRequest(1);
        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .contentType("application/json")
                .when().get("/main/test")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
    }


    @Test
    void createMainPageTest() {
        MainPageRequest mainPageRequest = new MainPageRequest(1);
        System.out.println("이게 뭐야?>??" + mainPageRequest.getArticleId());
        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .contentType("application/json")
                .body(mainPageRequest)
                .when().post("/main/create")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
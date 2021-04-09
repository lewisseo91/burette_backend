package com.takeon.burette.article;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import com.takeon.burette.AcceptanceTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

public class ArticleControllerTest extends AcceptanceTest {

    @Test
    void testTest() {
        System.out.println("asdb");
        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .when().get("/article/test")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void createArticleTest() {
        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .contentType("application/json")
                .body("{\"title\": \"asdfdsafdsa\", \"subTtile\" : \"absadfda\", \"thumbnail\" : \"[\"dafsda\"]\"}")
                .when().post("/article/create")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
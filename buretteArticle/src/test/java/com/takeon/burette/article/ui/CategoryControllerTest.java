package com.takeon.burette.article.ui;

import com.takeon.burette.AcceptanceTest;
import com.takeon.burette.article.dto.CategoryRequest;
import com.takeon.burette.article.dto.MainPageRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CategoryControllerTest extends AcceptanceTest {

    @Test
    void createCategoryTest() {
        CategoryRequest categoryRequest = new CategoryRequest("dsalkjfas");
        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .contentType("application/json")
                .body(categoryRequest)
                .when().post("/category/create")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
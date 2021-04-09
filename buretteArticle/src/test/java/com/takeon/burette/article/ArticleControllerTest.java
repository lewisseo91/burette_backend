package com.takeon.burette.article;

import com.takeon.burette.article.dto.ArticleCreateRequest;
import com.takeon.burette.article.dto.ArticleDeleteRequest;
import com.takeon.burette.article.dto.ArticleReadRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import com.takeon.burette.AcceptanceTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

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
        List<String> testThumbnail = new ArrayList<>();
        testThumbnail.add("abcd");
        List<String> testTags = new ArrayList<>();
        testThumbnail.add("tags");
        ArticleCreateRequest articleCreateRequest = new ArticleCreateRequest(0, "abc", "cbd", testThumbnail, "dsalkjfdsalk", testTags, 0);
        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .contentType("application/json")
                .body(articleCreateRequest)
                .when().post("/article/create")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void deleteArticleTest() {
//        List<String> testThumbnail = new ArrayList<>();
//        testThumbnail.add("abcd");
//        List<String> testTags = new ArrayList<>();
//        testThumbnail.add("tags");
//        ArticleCreateRequest articleCreateRequest = new ArticleCreateRequest(0, "abc", "cbd", testThumbnail, "dsalkjfdsalk", testTags, 0);
//        ExtractableResponse<Response> res = RestAssured
//                .given().log().all()
//                .contentType("application/json")
//                .body(articleCreateRequest)
//                .when().post("/article/create")
//                .then().log().all()
//                .extract();
//        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
//
        ArticleDeleteRequest articleDeleteRequest = new ArticleDeleteRequest(1);
        ExtractableResponse<Response> res2 = RestAssured
                .given().log().all()
                .contentType("application/json")
                .body(articleDeleteRequest)
                .when().post("/article/delete")
                .then().log().all()
                .extract();
        assertThat(res2.statusCode()).isEqualTo(HttpStatus.OK.value());
        System.out.println(res2.body());
    }

    @Test
    void getArticleTest() {
        ArticleReadRequest articleReadRequest = new ArticleReadRequest(1);
        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .contentType("application/json")
                .body(articleReadRequest)
                .when().post("/article/get")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
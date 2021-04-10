package com.takeon.burette.article.ui;

import com.takeon.burette.article.dto.ArticleRequest;
import com.takeon.burette.supports.api.UserClient;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import com.takeon.burette.AcceptanceTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ArticleControllerTest extends AcceptanceTest {

    @Test
    void testTest() {
        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .when().get("/article/test")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void isWritableTest() {
        UserClient uc = new UserClient();
        boolean isWritable = uc.isWritable("fdlkasjlfkdsajklfdsa");
        assertThat(isWritable).isFalse();
    }

    @Test
    void createArticleTest() {
        List<String> testThumbnail = new ArrayList<>();
        testThumbnail.add("abcd");
        List<String> testTags = new ArrayList<>();
        testThumbnail.add("tags");
        ArticleRequest articleRequest = new ArticleRequest(0, "abc", "cbd", testThumbnail, "dsalkjfdsalk", testTags, 3);
        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(articleRequest)
                .when().post("/article/create")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void deleteArticleTest() {
        List<String> testThumbnail = new ArrayList<>();
        testThumbnail.add("abcd");
        List<String> testTags = new ArrayList<>();
        testThumbnail.add("tags");
        ArticleRequest articleRequest = new ArticleRequest(0, "abc", "cbd", testThumbnail, "dsalkjfdsalk", testTags, 0);
        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(articleRequest)
                .when().post("/article/create")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());

        ArticleRequest articleRequest2 = new ArticleRequest(Integer.parseInt(res.body().asString()));
        ExtractableResponse<Response> res2 = RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(articleRequest2)
                .when().post("/article/delete")
                .then().log().all()
                .extract();
        assertThat(res2.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void getArticleTest() {
        ArticleRequest articleRequest = new ArticleRequest(1);
        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(articleRequest)
                .when().post("/article/get")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void getLatestCategoryTest() {
        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().post("/article/latest_category")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
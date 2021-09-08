package com.takeon.burette.article.ui;

import com.takeon.burette.article.dto.ArticleRequest;
import com.takeon.burette.article.dto.ArticleResponse;
import com.takeon.burette.article.dto.UserRequest;
import com.takeon.burette.article.dto.UserResponse;
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
//        UserClient uc = new UserClient();
//        boolean isWritable = uc.isWritable("fdlkasjlfkdsajklfdsa");
//        assertThat(isWritable).isFalse();
    }

    @Test
    void createArticleTest() {
        UserClient uc = new UserClient();
        UserRequest userRequest = new UserRequest("abc123123","adslkfjas", "dafslkjfdas", "dfklasjfdas", "010", "000", 0, 1);
        UserResponse responseUser = uc.createUser(userRequest);
        String token = uc.getTokenByUserId(responseUser.getUserId());

        List<String> testThumbnail = new ArrayList<>();
        testThumbnail.add("abcd");
        List<String> testTags = new ArrayList<>();
        testThumbnail.add("tags");
        ArticleRequest articleRequest = new ArticleRequest(0, "abc", "cbd", testThumbnail, "dsalkjfdsalk", testTags, 3);
        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header("authorization", token)
                .body(articleRequest)
                .when().post("/article/create")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void deleteArticleTest() {
        UserClient uc = new UserClient();
        UserRequest userRequest = new UserRequest("abc123123","adslkfjas", "dafslkjfdas", "dfklasjfdas", "000", "000", 0, 1);
        UserResponse responseUser = uc.createUser(userRequest);
        String token = uc.getTokenByUserId(responseUser.getUserId());

        List<String> testThumbnail = new ArrayList<>();
        testThumbnail.add("abcd");
        List<String> testTags = new ArrayList<>();
        testThumbnail.add("tags");
        ArticleRequest articleRequest = new ArticleRequest(0, "abc", "cbd", testThumbnail, "dsalkjfdsalk", testTags, 0);
        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header("authorization", token)
                .body(articleRequest)
                .when().post("/article/create")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
//        System.out.println(res.body().asString());
        ArticleResponse userResponse = res.body().as(ArticleResponse.class);
        Long id = userResponse.getId();

        ExtractableResponse<Response> res2 = RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header("authorization", token)
                .body(articleRequest)
                .when().delete("/article/delete/" + id)
                .then().log().all()
                .extract();
        assertThat(res2.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void getArticleTest() {
        createArticleTest();

        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("/article/get/1")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void getLatestCategoryTest() {
        createArticleTest();

        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("/article/latest_category")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
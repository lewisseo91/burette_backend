package com.takeon.burette.article.ui;

import com.takeon.burette.AcceptanceTest;
import com.takeon.burette.article.dto.*;
import com.takeon.burette.supports.api.UserClient;
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
        UserClient uc = new UserClient();
        UserRequest userRequest = new UserRequest("abc123123", "adslkfjas", "dafslkjfdas", "dfklasjfdas", "010-1111-1111", "000", 0, 1);
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

        ArticleResponse articleResponse = res.body().as(ArticleResponse.class);
        Long articleId = articleResponse.getId();

        MainPageRequest mainPageRequest = new MainPageRequest(articleId);
        ExtractableResponse<Response> res2 = RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(mainPageRequest)
                .when().post("/main/create")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
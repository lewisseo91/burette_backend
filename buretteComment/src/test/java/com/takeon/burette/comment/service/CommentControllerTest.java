package com.takeon.burette.comment.service;

import com.takeon.burette.AcceptanceTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("댓글 컨트롤러 테스트")
public class CommentControllerTest extends AcceptanceTest {


    @DisplayName("댓글 응답 테스트")
    @Test
    void testTest() {
        ExtractableResponse<Response> res = RestAssured
                .given().log().all()
                .when().get("/comment/test")
                .then().log().all()
                .extract();
        assertThat(res.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}

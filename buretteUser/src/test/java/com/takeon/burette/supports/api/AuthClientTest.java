package com.takeon.burette.supports.api;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthClientTest {


    @Test
    public void testTest() {
        String response = "1234";
        AuthClient authClient = new AuthClient();
        response = authClient.test();
        System.out.println(response);
    }

}

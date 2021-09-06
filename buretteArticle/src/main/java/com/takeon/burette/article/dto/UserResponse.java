package com.takeon.burette.article.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserResponse {
    private Long id;
    private String userId;
    private String password;
    private String nickname;
    private String email;
    private String phoneNumber;
    private String birthDay;
    private int gender;
    private int writePermission;

}


package com.takeon.burette.user.dto;

import lombok.Getter;

@Getter
public class UserRequest {
    private final String userId;
    private final String password;
    private final String nickname;
    private final String email;
    private final String phoneNumber;
    private final String birthDay;
    private final int gender;
    private final int writePermission;

    public UserRequest(String userId, String password, String nickname, String email, String phoneNumber, String birthDay, int gender, int writePermission) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.gender = gender;
        this.writePermission = writePermission;
    }

}

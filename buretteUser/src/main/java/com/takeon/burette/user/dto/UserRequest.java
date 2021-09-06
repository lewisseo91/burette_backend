package com.takeon.burette.user.dto;

import lombok.Getter;

@Getter
public class UserRequest {
    private String userId;
    private String password;
    private String nickname;
    private String email;
    private String phoneNumber;
    private String birthDay;
    private int gender;
    private int writePermission;

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

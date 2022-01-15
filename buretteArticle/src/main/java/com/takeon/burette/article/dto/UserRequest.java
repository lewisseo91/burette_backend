package com.takeon.burette.article.dto;

import java.util.List;

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


    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public int getGender() {
        return gender;
    }

    public int getWritePermission() {
        return writePermission;
    }
}

package com.takeon.burette.article.dto;

import java.util.List;

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

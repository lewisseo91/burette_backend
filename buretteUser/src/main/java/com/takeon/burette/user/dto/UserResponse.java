package com.takeon.burette.user.dto;

import com.takeon.burette.user.domain.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserResponse {
    private String userId;
    private String password;
    private String nickname;
    private String email;
    private String phoneNumber;
    private String birthDay;
    private int gender;
    private int writePermission;

    public UserResponse(User user) {
        this.userId = user.getUserId();
        this.password = user.getPassword();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.birthDay = user.getBirthDay();
        this.gender = user.getGender();
        this.writePermission = user.getWritePermission();
    }
}

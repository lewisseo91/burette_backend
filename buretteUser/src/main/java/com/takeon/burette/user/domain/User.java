package com.takeon.burette.user.domain;

import com.takeon.burette.user.dto.UserRequest;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String userId;
    private String password;
    private String nickname;
    private String email;
    private String phoneNumber;
    private String birthDay;
    private int gender;
    private int writePermission;

    public User(UserRequest userRequest) {
        this.userId = userRequest.getUserId();
        this.password = userRequest.getPassword();
        this.nickname = userRequest.getNickname();
        this.email = userRequest.getEmail();
        this.phoneNumber = userRequest.getPhoneNumber();
        this.birthDay = userRequest.getBirthDay();
        this.gender = userRequest.getGender();
        this.writePermission = userRequest.getWritePermission();
    }
}

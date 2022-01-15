package com.takeon.burette.user.service;

import com.takeon.burette.supports.api.AuthClient;
import com.takeon.burette.user.domain.User;
import com.takeon.burette.user.dto.LoginRequest;
import com.takeon.burette.user.dto.TokenRequest;
import com.takeon.burette.user.dto.UserRequest;
import com.takeon.burette.user.dto.UserResponse;
import com.takeon.burette.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private AuthClient authClient;

    public User save(UserRequest userRequest) {
        return userRepository.save(new User(userRequest));
    }

    public String loginUser(LoginRequest loginRequest) {
        if (!findIdAndPassword(loginRequest)) {
            return null;
        }

        return authClient.getToken(loginRequest.getUserId());
    }

    public boolean findIdAndPassword(LoginRequest loginRequest) {
        User user = userRepository.getUserByUserIdAndPassword(loginRequest.getUserId(), loginRequest.getPassword());
        return user != null;
    }

    public int getWritePermission(String userId) {
        return userRepository.getWritePermissionByUserId(userId);
    }

    public boolean isWritable(TokenRequest tokenRequest) {
        String userId = authClient.getUserId(tokenRequest.getToken());
        int permissionNumber = getWritePermission(userId);
        return permissionNumber != 0;
    }

    public UserResponse getUserByUserId(String userId) {
        User user = userRepository.getUserByUserId(userId);
        return new UserResponse(user);
    }

    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserResponse::new).collect(Collectors.toList());
    }
}

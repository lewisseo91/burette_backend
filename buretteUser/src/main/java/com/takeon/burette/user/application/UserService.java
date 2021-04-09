package com.takeon.burette.user.application;

import com.takeon.burette.supports.api.AuthClient;
import com.takeon.burette.user.dao.UserDao;
import com.takeon.burette.user.dto.LoginRequest;
import com.takeon.burette.user.dto.UserRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao userDao;
    private AuthClient authClient;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
        this.authClient = new AuthClient();
    }

    public int registerUser(UserRequest userRequest) {
        return userDao.save(userRequest);
    }

    public String loginUser(LoginRequest loginRequest) {
        if(!userDao.findIdAndPassword(loginRequest)) {
            return null;
        }
        String token = authClient.getToken(loginRequest.getUserId());

        return token;
    }
}

package com.takeon.burette.user.application;

import com.takeon.burette.user.dao.UserDao;
import com.takeon.burette.user.dto.UserRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public int registerUser(UserRequest userRequest) {
        return userDao.save(userRequest);
    }
}

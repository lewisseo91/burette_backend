package com.takeon.burette.user.dao;

import com.takeon.burette.user.dto.LoginRequest;
import com.takeon.burette.user.dto.UserRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;

@Repository
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(UserRequest userRequest) {
        String sql = "INSERT INTO USER(userId, password, nickname, email, phoneNumber, birthDay, gender, writePermission) VALUES(?,?,?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, new String[]{"id"});
            preparedStatement.setString(1, userRequest.getUserId());
            preparedStatement.setString(2, userRequest.getPassword());
            preparedStatement.setString(3, userRequest.getNickname());
            preparedStatement.setString(4, userRequest.getEmail());
            preparedStatement.setString(5, userRequest.getPhoneNumber());
            preparedStatement.setDate(6, Date.valueOf(userRequest.getBirthDay()));
            preparedStatement.setInt(7, userRequest.getGender());
            preparedStatement.setInt(8, userRequest.getWritePermission());
            return preparedStatement;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public boolean findIdAndPassword(LoginRequest loginRequest) {
        String sql = "SELECT id FROM USER WHERE userId = ? AND password = ?";
        return jdbcTemplate.queryForObject(sql, Boolean.class, loginRequest.getUserId(), loginRequest.getPassword());
    }
}

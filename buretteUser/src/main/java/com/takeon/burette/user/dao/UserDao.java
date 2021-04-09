package com.takeon.burette.user.dao;

import com.takeon.burette.user.dto.UserRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(UserRequest userRequest) {
        String sql = "INSERT INTO USER(userID, password, nickname, email, phoneNumber, birthDay, gender, writePermission) VALUES(?,?,?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, new String[]{"id"});
            preparedStatement.setString(1, userRequest.getUserId());
            preparedStatement.setString(2, userRequest.getPassword());
            preparedStatement.setString(3, userRequest.getNickname());
            preparedStatement.setString(4, userRequest.getEmail());
            preparedStatement.setString(5, userRequest.getPhoneNumber());
            preparedStatement.setString(6, userRequest.getBirthDay());
            preparedStatement.setInt(7, userRequest.getGender());
            preparedStatement.setInt(8, userRequest.getWritePermission());
            return preparedStatement;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

}

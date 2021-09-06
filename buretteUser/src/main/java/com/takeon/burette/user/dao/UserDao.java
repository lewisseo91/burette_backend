package com.takeon.burette.user.dao;

import com.takeon.burette.user.dto.LoginRequest;
import com.takeon.burette.user.dto.TokenRequest;
import com.takeon.burette.user.dto.UserRequest;
import com.takeon.burette.user.dto.UserResponse;
import org.apache.catalina.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

@Repository
public class UserDao {

    private SimpleDateFormat bFormat = new SimpleDateFormat("YYYY-MM-dd");

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
            preparedStatement.setDate(6, convertStringToDate(userRequest.getBirthDay()));
            preparedStatement.setInt(7, userRequest.getGender());
            preparedStatement.setInt(8, userRequest.getWritePermission());
            return preparedStatement;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public boolean findIdAndPassword(LoginRequest loginRequest) {
        String sql = "SELECT EXISTS (SELECT id FROM USER WHERE userId = ? AND password = ?)";
        return jdbcTemplate.queryForObject(sql, Boolean.class, loginRequest.getUserId(), loginRequest.getPassword());
    }

    public int getWritePermission(String id) {
        String sql = "SELECT writePermission FROM USER Where userId = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, id);
    }

    private Date convertStringToDate(String birthday) {
        Date date= null;
        try {
            date = (Date) bFormat.parse(birthday);
        } catch (ParseException e) {
        }
        return date;
    }

    public UserResponse getUserById(String userId) {
        String sql = "SELECT * FROM USER Where userId = ?";
//        jdbcTemplate.(connection -> {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql, new String[]{"id"});
//        });

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            UserResponse response = new UserResponse(
                    rs.getString("userId"),
                    rs.getString("password"),
                    rs.getString("nickname"),
                    rs.getString("email"),
                    rs.getString("phoneNumber"),
                    rs.getString("birthDay"),
                    rs.getInt("gender"),
                    rs.getInt("writePermission")
            );
            return response;
        }, userId);
    }
}

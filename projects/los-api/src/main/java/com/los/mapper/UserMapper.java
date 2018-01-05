package com.los.mapper;


import com.los.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by nuwantha on 11/11/16.
 */

public class UserMapper implements RowMapper {


    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user=new User();
        user.setUserId(resultSet.getInt("userid"));
        user.setUserName(resultSet.getString("Name"));
        user.setEmail(resultSet.getString("email"));
        user.setRole(resultSet.getString("role"));
        user.setDepId(resultSet.getString("dep_id"));
        return user;
    }

}

package com.los.mapper;


import com.los.entity.Meal;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MealMapper implements RowMapper {

    @Override
    public Meal mapRow(ResultSet resultSet, int i) throws SQLException {
        Meal meal = new Meal();
        meal.setMealId(resultSet.getInt("mealid"));
        meal.setMealName(resultSet.getString("mealname"));
        meal.setProviderId(resultSet.getInt("providerid"));
        meal.setPrice(resultSet.getInt("price"));

        return meal;
    }
}

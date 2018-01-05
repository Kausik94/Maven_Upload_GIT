package com.los.mapper;

import com.los.entity.FoodOrder;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper {

    @Override
    public FoodOrder mapRow(ResultSet resultSet, int i) throws SQLException {
        FoodOrder foodOrder = new FoodOrder();
        foodOrder.setOrderId(resultSet.getInt("orderid"));
        foodOrder.setDate(resultSet.getString("date"));
        foodOrder.setUserId(resultSet.getInt("userid"));
        foodOrder.setProviderId(resultSet.getInt("providerid"));
        foodOrder.setMeal(resultSet.getString("meal"));
        foodOrder.setQuantity(resultSet.getInt("quantity"));
        foodOrder.setAmount(resultSet.getInt("amount"));
        return foodOrder;
    }
}

package com.los.mapper;

import com.los.entity.Feedback;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class FeedbackMapper implements RowMapper{

    @Override
    public Feedback mapRow(ResultSet resultSet, int i) throws SQLException {
        Feedback feedback = new Feedback();
        feedback.setFeedbackId(resultSet.getInt("feedbackid"));
        feedback.setUserId(resultSet.getInt("userid"));
        feedback.setProviderId(resultSet.getInt("providerid"));
        feedback.setMeal(resultSet.getString("meal"));
        feedback.setFeedback(resultSet.getString("feedback"));
        return feedback;
    }
}

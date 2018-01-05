package com.los.service;

import com.los.data.access.FeedbackDao;
import com.los.entity.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FeedbackService {

    @Autowired
    FeedbackDao feedbackDao;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Feedback> getAllFeedbacks() {
        return feedbackDao.getAllFeedbacks();
    }

    public void addFeedback(Feedback feedback) {
        feedbackDao.addFeedback(feedback);
    }


}

package com.los.data.access;

import com.los.entity.Feedback;

import java.util.List;

public interface FeedbackDao {

     List<Feedback> getAllFeedbacks();
     public  void addFeedback(Feedback feedback);
}


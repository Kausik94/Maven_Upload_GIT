package com.los.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by nuwantha on 11/10/16.
 */
@XmlRootElement
public class Feedback {


    private int feedbackId;
    private int userId;
    private int providerId;
    private String meal;
    private String feedback;


    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }


}

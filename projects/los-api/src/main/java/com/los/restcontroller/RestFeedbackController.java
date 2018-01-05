package com.los.restcontroller;


import com.los.entity.Feedback;
import com.los.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
public class RestFeedbackController {


    @Autowired
    FeedbackService feedbackService;



//------------------------    Get all feedbacks ----------------------------------------------------

    @RequestMapping(
            value = "/api.feedback",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Feedback>> getAllFeedbacks(){
        List<Feedback> allFeedbacks = feedbackService.getAllFeedbacks();
        return new ResponseEntity<List<Feedback>>(allFeedbacks, HttpStatus.OK);
    }




//---------------------------------Add feedbacks---------------------------------------------------

    @RequestMapping(
            value = "/api.feedback.add",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Feedback> addNewFeedback(@RequestBody Feedback feedback) throws SQLException{
        System.out.println("add feedback is called");
        feedbackService.addFeedback(feedback);
        return new ResponseEntity<>(feedback,HttpStatus.OK);
    }
}

package com.verinite.bookstore.controller;

import com.verinite.bookstore.entity.Feedback;
import com.verinite.bookstore.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;
    @GetMapping("/getfeedback")
    public List<Feedback>getfeedback(){
        return feedbackService.getfeedback();
    }
    @PostMapping("/savefeedback")
    public Feedback createfeedback(@RequestBody Feedback feedback){
        return feedbackService.createfeedback(feedback);
    }
    @DeleteMapping("/deletefeed/{feedbackid}")
    public String deletefeed(@PathVariable int feedbackid){
        return feedbackService.deletefeed(feedbackid);
    }
}
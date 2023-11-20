package com.verinite.bookstore.serviceimpl;

import com.verinite.bookstore.entity.Feedback;
import com.verinite.bookstore.repository.FeedbackRepository;
import com.verinite.bookstore.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedbackRepository feedbackRepository;

    @Override
    public List<Feedback> getfeedback() {


        return feedbackRepository.find();
    }

    @Override
    public Feedback createfeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public String deletefeed(int feedbackid) {
        Feedback feedback1 = new Feedback();
        try {
            feedback1=feedbackRepository.getById(feedbackid);
        } catch (Exception e){
            return "feedbackid" + feedbackid + "is not present";
        }
        if(0 !=feedback1.getFeedbackid()&& !feedback1.getIsDeleted() ){
            feedback1.setIsDeleted(true);
            feedbackRepository.save(feedback1);
            return "delete successfully";
        } else if(feedback1.getIsDeleted()){
            return "deleted successfully";
        } else {
            return "deleted";
        }
    }
}

package com.verinite.bookstore.service;

import com.verinite.bookstore.entity.Feedback;

import java.util.List;

public interface FeedbackService {
  public   List<Feedback> getfeedback();

   public Feedback createfeedback(Feedback feedback);

  public   String deletefeed(int feedbackid);
}
package com.feedback.service;

import java.util.List;

import com.feedback.exception.BusinessException;
import com.feedback.model.Feedback;

public interface FeedbackService {

	public Feedback createFeedback(Feedback Feedback) throws BusinessException;

	public Feedback getFeedbackById(int id) throws BusinessException;

	public Feedback updateFeedback(Feedback Feedback) throws BusinessException;

	public void deleteFeedback(int id) throws BusinessException;

	public List<Feedback> getAllFeedbacks();
}

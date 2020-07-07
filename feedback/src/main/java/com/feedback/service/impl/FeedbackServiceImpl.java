package com.feedback.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.feedback.exception.BusinessException;
import com.feedback.dao.FeedbackDAO;
import com.feedback.model.Feedback;
import com.feedback.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	private FeedbackDAO dao;

	@Override
	public Feedback createFeedback(Feedback Feedback) {
		return dao.save(Feedback);

	}

	@Override
	public Feedback getFeedbackById(int id) throws BusinessException {
		Feedback feedback = null;
		try {
		feedback = dao.findById(id).get();
		}catch (NoSuchElementException e) {
			throw new BusinessException("No feedback found for id " + id);
		}
		return feedback;
	}

	@Override
	public Feedback updateFeedback(Feedback Feedback) {
		return dao.save(Feedback);

	}

	@Override
	public void deleteFeedback(int id) throws BusinessException {
		try {
			dao.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new BusinessException("No feedback found for id " + id);
		}

	}

	@Override
	public List<Feedback> getAllFeedbacks() {

		return dao.findAll();
	}

}

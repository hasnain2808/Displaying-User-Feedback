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

	private boolean isValidStarsOverall(int starsOverall) {
		if (starsOverall < 0 || starsOverall > 10) {
			return false;
		}
		return true;
	}

	private boolean isValidstarsAuthor(int starsAuthor) {
		if (starsAuthor < 0 || starsAuthor > 10) {
			return false;
		}
		return true;
	}

	@Override
	public Feedback createFeedback(Feedback Feedback) throws BusinessException {
		if (!isValidStarsOverall(Feedback.getStarsOverall())) {
			throw new BusinessException("starsOverall should be between 0 and 10");
		}
		if (!isValidstarsAuthor(Feedback.getStarsAuthor())) {
			throw new BusinessException("starsAuthor should be between 0 and 10");
		}
		return dao.save(Feedback);

	}

	@Override
	public Feedback getFeedbackById(int id) throws BusinessException {
		if (id < 0) {
			throw new BusinessException("id cannot be" + id);
		}
		Feedback feedback = null;
		try {
			feedback = dao.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new BusinessException("No feedback found for id " + id);
		}
		return feedback;
	}

	@Override
	public Feedback updateFeedback(Feedback Feedback) throws BusinessException {

		if (!isValidStarsOverall(Feedback.getStarsOverall())) {
			throw new BusinessException("starsOverall should be between 0 and 10");
		}
		if (!isValidstarsAuthor(Feedback.getStarsAuthor())) {
			throw new BusinessException("starsAuthor should be between 0 and 10");
		}

		if (Feedback.getId() < 0) {
			throw new BusinessException("id cannot be " + Feedback.getId());
		}
		try {
			dao.findById(Feedback.getId()).get();
		} catch (NoSuchElementException e) {
			throw new BusinessException("No feedback found for id " + Feedback.getId());
		}
		return dao.save(Feedback);

	}

	@Override
	public void deleteFeedback(int id) throws BusinessException {
		if (id < 0) {
			throw new BusinessException("id cannot be" + id);
		}
		try {
			dao.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new BusinessException("No feedback found for id " + id);
		}

	}

	@Override
	public List<Feedback> getAllFeedbacks() {

		return dao.findAll();
	}

}

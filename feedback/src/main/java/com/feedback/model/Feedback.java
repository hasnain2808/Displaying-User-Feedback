package com.feedback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String feedbackForAuthor;
	@Min(0)
	@Max(10)
	private int starsOverall;
	@Min(0)
	@Max(10)
	private int starsAuthor;
	private String feedbackOverall;
	private String bookName;
	private String extraComments;

	public Feedback() {
		super();
	}

	public Feedback(int id, String feedbackForAuthor, @Min(0) @Max(10) int starsOverall,
			@Min(0) @Max(10) int starsAuthor, String feedbackOverall, String bookName, String extraComments) {
		super();
		this.id = id;
		this.feedbackForAuthor = feedbackForAuthor;
		this.starsOverall = starsOverall;
		this.starsAuthor = starsAuthor;
		this.feedbackOverall = feedbackOverall;
		this.bookName = bookName;
		this.extraComments = extraComments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFeedbackForAuthor() {
		return feedbackForAuthor;
	}

	public void setFeedbackForAuthor(String feedbackForAuthor) {
		this.feedbackForAuthor = feedbackForAuthor;
	}

	public int getStarsOverall() {
		return starsOverall;
	}

	public void setStarsOverall(int starsOverall) {
		this.starsOverall = starsOverall;
	}

	public int getStarsAuthor() {
		return starsAuthor;
	}

	public void setStarsAuthor(int starsAuthor) {
		this.starsAuthor = starsAuthor;
	}

	public String getFeedbackOverall() {
		return feedbackOverall;
	}

	public void setFeedbackOverall(String feedbackOverall) {
		this.feedbackOverall = feedbackOverall;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getExtraComments() {
		return extraComments;
	}

	public void setExtraComments(String extraComments) {
		this.extraComments = extraComments;
	}

}

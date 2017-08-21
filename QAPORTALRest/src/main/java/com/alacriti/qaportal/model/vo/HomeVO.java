package com.alacriti.qaportal.model.vo;

import java.util.Date;

public class HomeVO {
	String question;
	String answer;
	String authorOfQuestion;
	String authorOfAnswer;
	Date postedTime;
	Date lastUpdatedTime;

	public HomeVO() {

	}

	public HomeVO(String question, String answer, String authorOfQuestion,
			String authorOfAnswer, Date postedTime, Date lastUpdatedTime) {
		super();
		this.question = question;
		this.answer = answer;
		this.authorOfQuestion = authorOfQuestion;
		this.authorOfAnswer = authorOfAnswer;
		this.postedTime = postedTime;
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAuthorOfQuestion() {
		return authorOfQuestion;
	}

	public void setAuthorOfQuestion(String authorOfQuestion) {
		this.authorOfQuestion = authorOfQuestion;
	}

	public String getAuthorOfAnswer() {
		return authorOfAnswer;
	}

	public void setAuthorOfAnswer(String authorOfAnswer) {
		this.authorOfAnswer = authorOfAnswer;
	}

	public Date getPostedTime() {
		return postedTime;
	}

	public void setPostedTime(Date postedTime) {
		this.postedTime = postedTime;
	}

	public Date getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(Date lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}
}

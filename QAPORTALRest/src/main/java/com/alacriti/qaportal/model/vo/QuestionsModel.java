package com.alacriti.qaportal.model.vo;

import java.util.Date;

public class QuestionsModel {
	public int questionId;
	public String userName;
	public String question;
	public Date postedTime;
	public QuestionsModel(int questionId, String userName, String question,
			Date postedTime) {
		super();
		this.questionId = questionId;
		this.userName = userName;
		this.question = question;
		this.postedTime = postedTime;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Date getPostedTime() {
		return postedTime;
	}
	public void setPostedTime(Date postedTime) {
		this.postedTime = postedTime;
	}
}
	
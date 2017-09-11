package com.alacriti.qaportal.model.vo;

import java.util.Date;

public class QuestionsModel {
	public int questionId;
	public String userName;
	public String question;
	public String postedTime;
	public String category;
	public QuestionsModel(){
		
	}
	public QuestionsModel(int questionId, String userName, String question,
			String postedTime) {
		super();
		this.questionId = questionId;
		this.userName = userName;
		this.question = question;
		this.postedTime = postedTime;
	}
	
	public QuestionsModel(String userName, String question, String postedTime,
			String category) {
		super();
		this.userName = userName;
		this.question = question;
		this.postedTime = postedTime;
		this.category = category;
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
	public String getPostedTime() {
		return postedTime;
	}
	public void setPostedTime(String postedTime) {
		this.postedTime = postedTime;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
	
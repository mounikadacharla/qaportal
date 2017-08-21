package com.alacriti.qaportal.model.vo;

import java.util.Date;

public class AnswersModel {
	public int questionId;
	public String userName;
	public String answer;
	public Date postedTime;
			public AnswersModel(){
				
			}
			public AnswersModel(int questionId, String userName, String answer,
					Date postedTime) {
				super();
				this.questionId = questionId;
				this.userName = userName;
				this.answer = answer;
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
			public String getAnswer() {
				return answer;
			}
			public void setAnswer(String answer) {
				this.answer = answer;
			}
			public Date getPostedTime() {
				return postedTime;
			}
			public void setPostedTime(Date postedTime) {
				this.postedTime = postedTime;
			}
}
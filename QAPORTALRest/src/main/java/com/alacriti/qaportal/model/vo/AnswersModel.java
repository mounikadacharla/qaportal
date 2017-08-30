package com.alacriti.qaportal.model.vo;

import java.util.Date;

public class AnswersModel {
	public int answerId;
	public String userName;
	public String answer;
	public Date postedTime;
	public int sid_person;
			public AnswersModel(){
				
			}
			public AnswersModel(int answerId, String userName, String answer,
					Date postedTime, int sid_person) {
				super();
				this.answerId = answerId;
				this.userName = userName;
				this.answer = answer;
				this.postedTime = postedTime;
				this.sid_person = sid_person;
			}
			public int getAnswerId() {
				return answerId;
			}
			public void setAnswerId(int answerId) {
				this.answerId = answerId;
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
			public int getSid_person() {
				return sid_person;
			}
			public void setSid_person(int sid_person) {
				this.sid_person = sid_person;
			}
}
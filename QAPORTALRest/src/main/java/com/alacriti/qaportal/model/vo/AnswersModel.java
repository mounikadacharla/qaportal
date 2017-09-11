package com.alacriti.qaportal.model.vo;

import java.sql.Timestamp;
import java.util.Date;

public class AnswersModel {
	public int answerId;
	public String userName;
	public String answer;
	public String postedTime;
	public int sid_person;
			public AnswersModel(){
				
			}
			public AnswersModel(int answerId, String userName, String answer,
					String postedTime, int sid_person) {
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
			public String getPostedTime() {
				return postedTime;
			}
			public void setPostedTime(String postedTime) {
				this.postedTime = postedTime;
			}
			public int getSid_person() {
				return sid_person;
			}
			public void setSid_person(int sid_person) {
				this.sid_person = sid_person;
			}
}
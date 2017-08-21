package com.alacriti.qaportal.model.vo;

public class AnsweringToAQuestionModel {
	
	public int sid_question;
	public int sid_person;
	public String answer;

	public AnsweringToAQuestionModel() {

	}

	public AnsweringToAQuestionModel( int sid_question,
			int sid_person, String answer) {
		super();
		this.sid_question = sid_question;
		this.sid_person = sid_person;
		this.answer = answer;
	}

	public int getSid_question() {
		return sid_question;
	}

	public void setSid_question(int sid_question) {
		this.sid_question = sid_question;
	}

	public int getSid_person() {
		return sid_person;
	}

	public void setSid_person(int sid_person) {
		this.sid_person = sid_person;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
